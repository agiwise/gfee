package ma.iam.wissal.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import ma.iam.wissal.IntegrationTest;
import ma.iam.wissal.domain.IndexReel;
import ma.iam.wissal.repository.IndexReelRepository;
import ma.iam.wissal.service.dto.IndexReelDTO;
import ma.iam.wissal.service.mapper.IndexReelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link IndexReelResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class IndexReelResourceIT {

    private static final String DEFAULT_NUMERO_IOC = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO_IOC = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_DEBUT_CONSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT_CONSO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN_CONSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN_CONSO = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_INDEX_DEBUT = 1L;
    private static final Long UPDATED_INDEX_DEBUT = 2L;

    private static final Long DEFAULT_INDEX_FIN = 1L;
    private static final Long UPDATED_INDEX_FIN = 2L;

    private static final LocalDate DEFAULT_DATE_VISITE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_VISITE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_ID_USER_CREATION = 1L;
    private static final Long UPDATED_ID_USER_CREATION = 2L;

    private static final String ENTITY_API_URL = "/api/index-reels";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private IndexReelRepository indexReelRepository;

    @Autowired
    private IndexReelMapper indexReelMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIndexReelMockMvc;

    private IndexReel indexReel;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IndexReel createEntity(EntityManager em) {
        IndexReel indexReel = new IndexReel()
            .numeroIOC(DEFAULT_NUMERO_IOC)
            .dateDebutConso(DEFAULT_DATE_DEBUT_CONSO)
            .dateFinConso(DEFAULT_DATE_FIN_CONSO)
            .indexDebut(DEFAULT_INDEX_DEBUT)
            .indexFin(DEFAULT_INDEX_FIN)
            .dateVisite(DEFAULT_DATE_VISITE)
            .dateCreation(DEFAULT_DATE_CREATION)
            .idUserCreation(DEFAULT_ID_USER_CREATION);
        return indexReel;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IndexReel createUpdatedEntity(EntityManager em) {
        IndexReel indexReel = new IndexReel()
            .numeroIOC(UPDATED_NUMERO_IOC)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .indexDebut(UPDATED_INDEX_DEBUT)
            .indexFin(UPDATED_INDEX_FIN)
            .dateVisite(UPDATED_DATE_VISITE)
            .dateCreation(UPDATED_DATE_CREATION)
            .idUserCreation(UPDATED_ID_USER_CREATION);
        return indexReel;
    }

    @BeforeEach
    public void initTest() {
        indexReel = createEntity(em);
    }

    @Test
    @Transactional
    void createIndexReel() throws Exception {
        int databaseSizeBeforeCreate = indexReelRepository.findAll().size();
        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);
        restIndexReelMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(indexReelDTO)))
            .andExpect(status().isCreated());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeCreate + 1);
        IndexReel testIndexReel = indexReelList.get(indexReelList.size() - 1);
        assertThat(testIndexReel.getNumeroIOC()).isEqualTo(DEFAULT_NUMERO_IOC);
        assertThat(testIndexReel.getDateDebutConso()).isEqualTo(DEFAULT_DATE_DEBUT_CONSO);
        assertThat(testIndexReel.getDateFinConso()).isEqualTo(DEFAULT_DATE_FIN_CONSO);
        assertThat(testIndexReel.getIndexDebut()).isEqualTo(DEFAULT_INDEX_DEBUT);
        assertThat(testIndexReel.getIndexFin()).isEqualTo(DEFAULT_INDEX_FIN);
        assertThat(testIndexReel.getDateVisite()).isEqualTo(DEFAULT_DATE_VISITE);
        assertThat(testIndexReel.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testIndexReel.getIdUserCreation()).isEqualTo(DEFAULT_ID_USER_CREATION);
    }

    @Test
    @Transactional
    void createIndexReelWithExistingId() throws Exception {
        // Create the IndexReel with an existing ID
        indexReel.setId(1L);
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        int databaseSizeBeforeCreate = indexReelRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restIndexReelMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(indexReelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllIndexReels() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        // Get all the indexReelList
        restIndexReelMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(indexReel.getId().intValue())))
            .andExpect(jsonPath("$.[*].numeroIOC").value(hasItem(DEFAULT_NUMERO_IOC)))
            .andExpect(jsonPath("$.[*].dateDebutConso").value(hasItem(DEFAULT_DATE_DEBUT_CONSO.toString())))
            .andExpect(jsonPath("$.[*].dateFinConso").value(hasItem(DEFAULT_DATE_FIN_CONSO.toString())))
            .andExpect(jsonPath("$.[*].indexDebut").value(hasItem(DEFAULT_INDEX_DEBUT.intValue())))
            .andExpect(jsonPath("$.[*].indexFin").value(hasItem(DEFAULT_INDEX_FIN.intValue())))
            .andExpect(jsonPath("$.[*].dateVisite").value(hasItem(DEFAULT_DATE_VISITE.toString())))
            .andExpect(jsonPath("$.[*].dateCreation").value(hasItem(DEFAULT_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].idUserCreation").value(hasItem(DEFAULT_ID_USER_CREATION.intValue())));
    }

    @Test
    @Transactional
    void getIndexReel() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        // Get the indexReel
        restIndexReelMockMvc
            .perform(get(ENTITY_API_URL_ID, indexReel.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(indexReel.getId().intValue()))
            .andExpect(jsonPath("$.numeroIOC").value(DEFAULT_NUMERO_IOC))
            .andExpect(jsonPath("$.dateDebutConso").value(DEFAULT_DATE_DEBUT_CONSO.toString()))
            .andExpect(jsonPath("$.dateFinConso").value(DEFAULT_DATE_FIN_CONSO.toString()))
            .andExpect(jsonPath("$.indexDebut").value(DEFAULT_INDEX_DEBUT.intValue()))
            .andExpect(jsonPath("$.indexFin").value(DEFAULT_INDEX_FIN.intValue()))
            .andExpect(jsonPath("$.dateVisite").value(DEFAULT_DATE_VISITE.toString()))
            .andExpect(jsonPath("$.dateCreation").value(DEFAULT_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.idUserCreation").value(DEFAULT_ID_USER_CREATION.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingIndexReel() throws Exception {
        // Get the indexReel
        restIndexReelMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewIndexReel() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();

        // Update the indexReel
        IndexReel updatedIndexReel = indexReelRepository.findById(indexReel.getId()).get();
        // Disconnect from session so that the updates on updatedIndexReel are not directly saved in db
        em.detach(updatedIndexReel);
        updatedIndexReel
            .numeroIOC(UPDATED_NUMERO_IOC)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .indexDebut(UPDATED_INDEX_DEBUT)
            .indexFin(UPDATED_INDEX_FIN)
            .dateVisite(UPDATED_DATE_VISITE)
            .dateCreation(UPDATED_DATE_CREATION)
            .idUserCreation(UPDATED_ID_USER_CREATION);
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(updatedIndexReel);

        restIndexReelMockMvc
            .perform(
                put(ENTITY_API_URL_ID, indexReelDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isOk());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
        IndexReel testIndexReel = indexReelList.get(indexReelList.size() - 1);
        assertThat(testIndexReel.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIndexReel.getDateDebutConso()).isEqualTo(UPDATED_DATE_DEBUT_CONSO);
        assertThat(testIndexReel.getDateFinConso()).isEqualTo(UPDATED_DATE_FIN_CONSO);
        assertThat(testIndexReel.getIndexDebut()).isEqualTo(UPDATED_INDEX_DEBUT);
        assertThat(testIndexReel.getIndexFin()).isEqualTo(UPDATED_INDEX_FIN);
        assertThat(testIndexReel.getDateVisite()).isEqualTo(UPDATED_DATE_VISITE);
        assertThat(testIndexReel.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testIndexReel.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
    }

    @Test
    @Transactional
    void putNonExistingIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(
                put(ENTITY_API_URL_ID, indexReelDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(indexReelDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateIndexReelWithPatch() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();

        // Update the indexReel using partial update
        IndexReel partialUpdatedIndexReel = new IndexReel();
        partialUpdatedIndexReel.setId(indexReel.getId());

        partialUpdatedIndexReel.numeroIOC(UPDATED_NUMERO_IOC).idUserCreation(UPDATED_ID_USER_CREATION);

        restIndexReelMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIndexReel.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIndexReel))
            )
            .andExpect(status().isOk());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
        IndexReel testIndexReel = indexReelList.get(indexReelList.size() - 1);
        assertThat(testIndexReel.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIndexReel.getDateDebutConso()).isEqualTo(DEFAULT_DATE_DEBUT_CONSO);
        assertThat(testIndexReel.getDateFinConso()).isEqualTo(DEFAULT_DATE_FIN_CONSO);
        assertThat(testIndexReel.getIndexDebut()).isEqualTo(DEFAULT_INDEX_DEBUT);
        assertThat(testIndexReel.getIndexFin()).isEqualTo(DEFAULT_INDEX_FIN);
        assertThat(testIndexReel.getDateVisite()).isEqualTo(DEFAULT_DATE_VISITE);
        assertThat(testIndexReel.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testIndexReel.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
    }

    @Test
    @Transactional
    void fullUpdateIndexReelWithPatch() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();

        // Update the indexReel using partial update
        IndexReel partialUpdatedIndexReel = new IndexReel();
        partialUpdatedIndexReel.setId(indexReel.getId());

        partialUpdatedIndexReel
            .numeroIOC(UPDATED_NUMERO_IOC)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .indexDebut(UPDATED_INDEX_DEBUT)
            .indexFin(UPDATED_INDEX_FIN)
            .dateVisite(UPDATED_DATE_VISITE)
            .dateCreation(UPDATED_DATE_CREATION)
            .idUserCreation(UPDATED_ID_USER_CREATION);

        restIndexReelMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIndexReel.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIndexReel))
            )
            .andExpect(status().isOk());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
        IndexReel testIndexReel = indexReelList.get(indexReelList.size() - 1);
        assertThat(testIndexReel.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIndexReel.getDateDebutConso()).isEqualTo(UPDATED_DATE_DEBUT_CONSO);
        assertThat(testIndexReel.getDateFinConso()).isEqualTo(UPDATED_DATE_FIN_CONSO);
        assertThat(testIndexReel.getIndexDebut()).isEqualTo(UPDATED_INDEX_DEBUT);
        assertThat(testIndexReel.getIndexFin()).isEqualTo(UPDATED_INDEX_FIN);
        assertThat(testIndexReel.getDateVisite()).isEqualTo(UPDATED_DATE_VISITE);
        assertThat(testIndexReel.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testIndexReel.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
    }

    @Test
    @Transactional
    void patchNonExistingIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, indexReelDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamIndexReel() throws Exception {
        int databaseSizeBeforeUpdate = indexReelRepository.findAll().size();
        indexReel.setId(count.incrementAndGet());

        // Create the IndexReel
        IndexReelDTO indexReelDTO = indexReelMapper.toDto(indexReel);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIndexReelMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(indexReelDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the IndexReel in the database
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteIndexReel() throws Exception {
        // Initialize the database
        indexReelRepository.saveAndFlush(indexReel);

        int databaseSizeBeforeDelete = indexReelRepository.findAll().size();

        // Delete the indexReel
        restIndexReelMockMvc
            .perform(delete(ENTITY_API_URL_ID, indexReel.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IndexReel> indexReelList = indexReelRepository.findAll();
        assertThat(indexReelList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
