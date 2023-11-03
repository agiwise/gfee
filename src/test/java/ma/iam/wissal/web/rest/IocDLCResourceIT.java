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
import ma.iam.wissal.domain.IocDLC;
import ma.iam.wissal.repository.IocDLCRepository;
import ma.iam.wissal.service.dto.IocDLCDTO;
import ma.iam.wissal.service.mapper.IocDLCMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link IocDLCResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class IocDLCResourceIT {

    private static final Long DEFAULT_ID_IOC = 1L;
    private static final Long UPDATED_ID_IOC = 2L;

    private static final Long DEFAULT_NUMERO_IOC = 1L;
    private static final Long UPDATED_NUMERO_IOC = 2L;

    private static final String DEFAULT_LIBELLE_IOC = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE_IOC = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/ioc-dlcs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private IocDLCRepository iocDLCRepository;

    @Autowired
    private IocDLCMapper iocDLCMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIocDLCMockMvc;

    private IocDLC iocDLC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IocDLC createEntity(EntityManager em) {
        IocDLC iocDLC = new IocDLC().idIOC(DEFAULT_ID_IOC).numeroIOC(DEFAULT_NUMERO_IOC).libelleIOC(DEFAULT_LIBELLE_IOC);
        return iocDLC;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IocDLC createUpdatedEntity(EntityManager em) {
        IocDLC iocDLC = new IocDLC().idIOC(UPDATED_ID_IOC).numeroIOC(UPDATED_NUMERO_IOC).libelleIOC(UPDATED_LIBELLE_IOC);
        return iocDLC;
    }

    @BeforeEach
    public void initTest() {
        iocDLC = createEntity(em);
    }

    @Test
    @Transactional
    void createIocDLC() throws Exception {
        int databaseSizeBeforeCreate = iocDLCRepository.findAll().size();
        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);
        restIocDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iocDLCDTO)))
            .andExpect(status().isCreated());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeCreate + 1);
        IocDLC testIocDLC = iocDLCList.get(iocDLCList.size() - 1);
        assertThat(testIocDLC.getIdIOC()).isEqualTo(DEFAULT_ID_IOC);
        assertThat(testIocDLC.getNumeroIOC()).isEqualTo(DEFAULT_NUMERO_IOC);
        assertThat(testIocDLC.getLibelleIOC()).isEqualTo(DEFAULT_LIBELLE_IOC);
    }

    @Test
    @Transactional
    void createIocDLCWithExistingId() throws Exception {
        // Create the IocDLC with an existing ID
        iocDLC.setId(1L);
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        int databaseSizeBeforeCreate = iocDLCRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restIocDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iocDLCDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllIocDLCS() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        // Get all the iocDLCList
        restIocDLCMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(iocDLC.getId().intValue())))
            .andExpect(jsonPath("$.[*].idIOC").value(hasItem(DEFAULT_ID_IOC.intValue())))
            .andExpect(jsonPath("$.[*].numeroIOC").value(hasItem(DEFAULT_NUMERO_IOC.intValue())))
            .andExpect(jsonPath("$.[*].libelleIOC").value(hasItem(DEFAULT_LIBELLE_IOC)));
    }

    @Test
    @Transactional
    void getIocDLC() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        // Get the iocDLC
        restIocDLCMockMvc
            .perform(get(ENTITY_API_URL_ID, iocDLC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(iocDLC.getId().intValue()))
            .andExpect(jsonPath("$.idIOC").value(DEFAULT_ID_IOC.intValue()))
            .andExpect(jsonPath("$.numeroIOC").value(DEFAULT_NUMERO_IOC.intValue()))
            .andExpect(jsonPath("$.libelleIOC").value(DEFAULT_LIBELLE_IOC));
    }

    @Test
    @Transactional
    void getNonExistingIocDLC() throws Exception {
        // Get the iocDLC
        restIocDLCMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewIocDLC() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();

        // Update the iocDLC
        IocDLC updatedIocDLC = iocDLCRepository.findById(iocDLC.getId()).get();
        // Disconnect from session so that the updates on updatedIocDLC are not directly saved in db
        em.detach(updatedIocDLC);
        updatedIocDLC.idIOC(UPDATED_ID_IOC).numeroIOC(UPDATED_NUMERO_IOC).libelleIOC(UPDATED_LIBELLE_IOC);
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(updatedIocDLC);

        restIocDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, iocDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isOk());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
        IocDLC testIocDLC = iocDLCList.get(iocDLCList.size() - 1);
        assertThat(testIocDLC.getIdIOC()).isEqualTo(UPDATED_ID_IOC);
        assertThat(testIocDLC.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIocDLC.getLibelleIOC()).isEqualTo(UPDATED_LIBELLE_IOC);
    }

    @Test
    @Transactional
    void putNonExistingIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, iocDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iocDLCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateIocDLCWithPatch() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();

        // Update the iocDLC using partial update
        IocDLC partialUpdatedIocDLC = new IocDLC();
        partialUpdatedIocDLC.setId(iocDLC.getId());

        partialUpdatedIocDLC.numeroIOC(UPDATED_NUMERO_IOC);

        restIocDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIocDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIocDLC))
            )
            .andExpect(status().isOk());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
        IocDLC testIocDLC = iocDLCList.get(iocDLCList.size() - 1);
        assertThat(testIocDLC.getIdIOC()).isEqualTo(DEFAULT_ID_IOC);
        assertThat(testIocDLC.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIocDLC.getLibelleIOC()).isEqualTo(DEFAULT_LIBELLE_IOC);
    }

    @Test
    @Transactional
    void fullUpdateIocDLCWithPatch() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();

        // Update the iocDLC using partial update
        IocDLC partialUpdatedIocDLC = new IocDLC();
        partialUpdatedIocDLC.setId(iocDLC.getId());

        partialUpdatedIocDLC.idIOC(UPDATED_ID_IOC).numeroIOC(UPDATED_NUMERO_IOC).libelleIOC(UPDATED_LIBELLE_IOC);

        restIocDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIocDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIocDLC))
            )
            .andExpect(status().isOk());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
        IocDLC testIocDLC = iocDLCList.get(iocDLCList.size() - 1);
        assertThat(testIocDLC.getIdIOC()).isEqualTo(UPDATED_ID_IOC);
        assertThat(testIocDLC.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIocDLC.getLibelleIOC()).isEqualTo(UPDATED_LIBELLE_IOC);
    }

    @Test
    @Transactional
    void patchNonExistingIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, iocDLCDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamIocDLC() throws Exception {
        int databaseSizeBeforeUpdate = iocDLCRepository.findAll().size();
        iocDLC.setId(count.incrementAndGet());

        // Create the IocDLC
        IocDLCDTO iocDLCDTO = iocDLCMapper.toDto(iocDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIocDLCMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(iocDLCDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the IocDLC in the database
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteIocDLC() throws Exception {
        // Initialize the database
        iocDLCRepository.saveAndFlush(iocDLC);

        int databaseSizeBeforeDelete = iocDLCRepository.findAll().size();

        // Delete the iocDLC
        restIocDLCMockMvc
            .perform(delete(ENTITY_API_URL_ID, iocDLC.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IocDLC> iocDLCList = iocDLCRepository.findAll();
        assertThat(iocDLCList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
