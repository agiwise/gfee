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
import ma.iam.wissal.domain.MemoireDLC;
import ma.iam.wissal.repository.MemoireDLCRepository;
import ma.iam.wissal.service.dto.MemoireDLCDTO;
import ma.iam.wissal.service.mapper.MemoireDLCMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link MemoireDLCResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MemoireDLCResourceIT {

    private static final Long DEFAULT_CODE_MEMOIRE = 1L;
    private static final Long UPDATED_CODE_MEMOIRE = 2L;

    private static final String DEFAULT_LIBELLE_DIRECTION = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE_DIRECTION = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE_DLC = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE_DLC = "BBBBBBBBBB";

    private static final String DEFAULT_STATUT_MEMOIRE = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_MEMOIRE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/memoire-dlcs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MemoireDLCRepository memoireDLCRepository;

    @Autowired
    private MemoireDLCMapper memoireDLCMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMemoireDLCMockMvc;

    private MemoireDLC memoireDLC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MemoireDLC createEntity(EntityManager em) {
        MemoireDLC memoireDLC = new MemoireDLC()
            .codeMemoire(DEFAULT_CODE_MEMOIRE)
            .libelleDirection(DEFAULT_LIBELLE_DIRECTION)
            .libelleDLC(DEFAULT_LIBELLE_DLC)
            .statutMemoire(DEFAULT_STATUT_MEMOIRE);
        return memoireDLC;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MemoireDLC createUpdatedEntity(EntityManager em) {
        MemoireDLC memoireDLC = new MemoireDLC()
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .libelleDirection(UPDATED_LIBELLE_DIRECTION)
            .libelleDLC(UPDATED_LIBELLE_DLC)
            .statutMemoire(UPDATED_STATUT_MEMOIRE);
        return memoireDLC;
    }

    @BeforeEach
    public void initTest() {
        memoireDLC = createEntity(em);
    }

    @Test
    @Transactional
    void createMemoireDLC() throws Exception {
        int databaseSizeBeforeCreate = memoireDLCRepository.findAll().size();
        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);
        restMemoireDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO)))
            .andExpect(status().isCreated());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeCreate + 1);
        MemoireDLC testMemoireDLC = memoireDLCList.get(memoireDLCList.size() - 1);
        assertThat(testMemoireDLC.getCodeMemoire()).isEqualTo(DEFAULT_CODE_MEMOIRE);
        assertThat(testMemoireDLC.getLibelleDirection()).isEqualTo(DEFAULT_LIBELLE_DIRECTION);
        assertThat(testMemoireDLC.getLibelleDLC()).isEqualTo(DEFAULT_LIBELLE_DLC);
        assertThat(testMemoireDLC.getStatutMemoire()).isEqualTo(DEFAULT_STATUT_MEMOIRE);
    }

    @Test
    @Transactional
    void createMemoireDLCWithExistingId() throws Exception {
        // Create the MemoireDLC with an existing ID
        memoireDLC.setId(1L);
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        int databaseSizeBeforeCreate = memoireDLCRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restMemoireDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllMemoireDLCS() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        // Get all the memoireDLCList
        restMemoireDLCMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(memoireDLC.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeMemoire").value(hasItem(DEFAULT_CODE_MEMOIRE.intValue())))
            .andExpect(jsonPath("$.[*].libelleDirection").value(hasItem(DEFAULT_LIBELLE_DIRECTION)))
            .andExpect(jsonPath("$.[*].libelleDLC").value(hasItem(DEFAULT_LIBELLE_DLC)))
            .andExpect(jsonPath("$.[*].statutMemoire").value(hasItem(DEFAULT_STATUT_MEMOIRE)));
    }

    @Test
    @Transactional
    void getMemoireDLC() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        // Get the memoireDLC
        restMemoireDLCMockMvc
            .perform(get(ENTITY_API_URL_ID, memoireDLC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(memoireDLC.getId().intValue()))
            .andExpect(jsonPath("$.codeMemoire").value(DEFAULT_CODE_MEMOIRE.intValue()))
            .andExpect(jsonPath("$.libelleDirection").value(DEFAULT_LIBELLE_DIRECTION))
            .andExpect(jsonPath("$.libelleDLC").value(DEFAULT_LIBELLE_DLC))
            .andExpect(jsonPath("$.statutMemoire").value(DEFAULT_STATUT_MEMOIRE));
    }

    @Test
    @Transactional
    void getNonExistingMemoireDLC() throws Exception {
        // Get the memoireDLC
        restMemoireDLCMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewMemoireDLC() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();

        // Update the memoireDLC
        MemoireDLC updatedMemoireDLC = memoireDLCRepository.findById(memoireDLC.getId()).get();
        // Disconnect from session so that the updates on updatedMemoireDLC are not directly saved in db
        em.detach(updatedMemoireDLC);
        updatedMemoireDLC
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .libelleDirection(UPDATED_LIBELLE_DIRECTION)
            .libelleDLC(UPDATED_LIBELLE_DLC)
            .statutMemoire(UPDATED_STATUT_MEMOIRE);
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(updatedMemoireDLC);

        restMemoireDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, memoireDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isOk());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
        MemoireDLC testMemoireDLC = memoireDLCList.get(memoireDLCList.size() - 1);
        assertThat(testMemoireDLC.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoireDLC.getLibelleDirection()).isEqualTo(UPDATED_LIBELLE_DIRECTION);
        assertThat(testMemoireDLC.getLibelleDLC()).isEqualTo(UPDATED_LIBELLE_DLC);
        assertThat(testMemoireDLC.getStatutMemoire()).isEqualTo(UPDATED_STATUT_MEMOIRE);
    }

    @Test
    @Transactional
    void putNonExistingMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, memoireDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateMemoireDLCWithPatch() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();

        // Update the memoireDLC using partial update
        MemoireDLC partialUpdatedMemoireDLC = new MemoireDLC();
        partialUpdatedMemoireDLC.setId(memoireDLC.getId());

        partialUpdatedMemoireDLC.codeMemoire(UPDATED_CODE_MEMOIRE);

        restMemoireDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMemoireDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMemoireDLC))
            )
            .andExpect(status().isOk());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
        MemoireDLC testMemoireDLC = memoireDLCList.get(memoireDLCList.size() - 1);
        assertThat(testMemoireDLC.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoireDLC.getLibelleDirection()).isEqualTo(DEFAULT_LIBELLE_DIRECTION);
        assertThat(testMemoireDLC.getLibelleDLC()).isEqualTo(DEFAULT_LIBELLE_DLC);
        assertThat(testMemoireDLC.getStatutMemoire()).isEqualTo(DEFAULT_STATUT_MEMOIRE);
    }

    @Test
    @Transactional
    void fullUpdateMemoireDLCWithPatch() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();

        // Update the memoireDLC using partial update
        MemoireDLC partialUpdatedMemoireDLC = new MemoireDLC();
        partialUpdatedMemoireDLC.setId(memoireDLC.getId());

        partialUpdatedMemoireDLC
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .libelleDirection(UPDATED_LIBELLE_DIRECTION)
            .libelleDLC(UPDATED_LIBELLE_DLC)
            .statutMemoire(UPDATED_STATUT_MEMOIRE);

        restMemoireDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMemoireDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMemoireDLC))
            )
            .andExpect(status().isOk());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
        MemoireDLC testMemoireDLC = memoireDLCList.get(memoireDLCList.size() - 1);
        assertThat(testMemoireDLC.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoireDLC.getLibelleDirection()).isEqualTo(UPDATED_LIBELLE_DIRECTION);
        assertThat(testMemoireDLC.getLibelleDLC()).isEqualTo(UPDATED_LIBELLE_DLC);
        assertThat(testMemoireDLC.getStatutMemoire()).isEqualTo(UPDATED_STATUT_MEMOIRE);
    }

    @Test
    @Transactional
    void patchNonExistingMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, memoireDLCDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamMemoireDLC() throws Exception {
        int databaseSizeBeforeUpdate = memoireDLCRepository.findAll().size();
        memoireDLC.setId(count.incrementAndGet());

        // Create the MemoireDLC
        MemoireDLCDTO memoireDLCDTO = memoireDLCMapper.toDto(memoireDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireDLCMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(memoireDLCDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the MemoireDLC in the database
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteMemoireDLC() throws Exception {
        // Initialize the database
        memoireDLCRepository.saveAndFlush(memoireDLC);

        int databaseSizeBeforeDelete = memoireDLCRepository.findAll().size();

        // Delete the memoireDLC
        restMemoireDLCMockMvc
            .perform(delete(ENTITY_API_URL_ID, memoireDLC.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MemoireDLC> memoireDLCList = memoireDLCRepository.findAll();
        assertThat(memoireDLCList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
