package ma.iam.wissal.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import ma.iam.wissal.IntegrationTest;
import ma.iam.wissal.domain.DLC;
import ma.iam.wissal.repository.DLCRepository;
import ma.iam.wissal.service.dto.DLCDTO;
import ma.iam.wissal.service.mapper.DLCMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link DLCResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DLCResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final Long DEFAULT_ID_DIRECTION_REGIONALE = 1L;
    private static final Long UPDATED_ID_DIRECTION_REGIONALE = 2L;

    private static final String ENTITY_API_URL = "/api/dlcs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DLCRepository dLCRepository;

    @Autowired
    private DLCMapper dLCMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDLCMockMvc;

    private DLC dLC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DLC createEntity(EntityManager em) {
        DLC dLC = new DLC().libelle(DEFAULT_LIBELLE).idDirectionRegionale(DEFAULT_ID_DIRECTION_REGIONALE);
        return dLC;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DLC createUpdatedEntity(EntityManager em) {
        DLC dLC = new DLC().libelle(UPDATED_LIBELLE).idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE);
        return dLC;
    }

    @BeforeEach
    public void initTest() {
        dLC = createEntity(em);
    }

    @Test
    @Transactional
    void createDLC() throws Exception {
        int databaseSizeBeforeCreate = dLCRepository.findAll().size();
        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);
        restDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dLCDTO)))
            .andExpect(status().isCreated());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeCreate + 1);
        DLC testDLC = dLCList.get(dLCList.size() - 1);
        assertThat(testDLC.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testDLC.getIdDirectionRegionale()).isEqualTo(DEFAULT_ID_DIRECTION_REGIONALE);
    }

    @Test
    @Transactional
    void createDLCWithExistingId() throws Exception {
        // Create the DLC with an existing ID
        dLC.setId(1L);
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        int databaseSizeBeforeCreate = dLCRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dLCDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllDLCS() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        // Get all the dLCList
        restDLCMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dLC.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].idDirectionRegionale").value(hasItem(DEFAULT_ID_DIRECTION_REGIONALE.intValue())));
    }

    @Test
    @Transactional
    void getDLC() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        // Get the dLC
        restDLCMockMvc
            .perform(get(ENTITY_API_URL_ID, dLC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dLC.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.idDirectionRegionale").value(DEFAULT_ID_DIRECTION_REGIONALE.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingDLC() throws Exception {
        // Get the dLC
        restDLCMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewDLC() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();

        // Update the dLC
        DLC updatedDLC = dLCRepository.findById(dLC.getId()).get();
        // Disconnect from session so that the updates on updatedDLC are not directly saved in db
        em.detach(updatedDLC);
        updatedDLC.libelle(UPDATED_LIBELLE).idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE);
        DLCDTO dLCDTO = dLCMapper.toDto(updatedDLC);

        restDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dLCDTO))
            )
            .andExpect(status().isOk());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
        DLC testDLC = dLCList.get(dLCList.size() - 1);
        assertThat(testDLC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testDLC.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
    }

    @Test
    @Transactional
    void putNonExistingDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(dLCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDLCWithPatch() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();

        // Update the dLC using partial update
        DLC partialUpdatedDLC = new DLC();
        partialUpdatedDLC.setId(dLC.getId());

        partialUpdatedDLC.libelle(UPDATED_LIBELLE);

        restDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDLC))
            )
            .andExpect(status().isOk());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
        DLC testDLC = dLCList.get(dLCList.size() - 1);
        assertThat(testDLC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testDLC.getIdDirectionRegionale()).isEqualTo(DEFAULT_ID_DIRECTION_REGIONALE);
    }

    @Test
    @Transactional
    void fullUpdateDLCWithPatch() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();

        // Update the dLC using partial update
        DLC partialUpdatedDLC = new DLC();
        partialUpdatedDLC.setId(dLC.getId());

        partialUpdatedDLC.libelle(UPDATED_LIBELLE).idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE);

        restDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDLC))
            )
            .andExpect(status().isOk());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
        DLC testDLC = dLCList.get(dLCList.size() - 1);
        assertThat(testDLC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testDLC.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
    }

    @Test
    @Transactional
    void patchNonExistingDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, dLCDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDLC() throws Exception {
        int databaseSizeBeforeUpdate = dLCRepository.findAll().size();
        dLC.setId(count.incrementAndGet());

        // Create the DLC
        DLCDTO dLCDTO = dLCMapper.toDto(dLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDLCMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(dLCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DLC in the database
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDLC() throws Exception {
        // Initialize the database
        dLCRepository.saveAndFlush(dLC);

        int databaseSizeBeforeDelete = dLCRepository.findAll().size();

        // Delete the dLC
        restDLCMockMvc.perform(delete(ENTITY_API_URL_ID, dLC.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DLC> dLCList = dLCRepository.findAll();
        assertThat(dLCList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
