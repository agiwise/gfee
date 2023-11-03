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
import ma.iam.wissal.domain.PIECESAP;
import ma.iam.wissal.repository.PIECESAPRepository;
import ma.iam.wissal.service.dto.PIECESAPDTO;
import ma.iam.wissal.service.mapper.PIECESAPMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link PIECESAPResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PIECESAPResourceIT {

    private static final Long DEFAULT_ID_DLC = 1L;
    private static final Long UPDATED_ID_DLC = 2L;

    private static final Long DEFAULT_ID_DIRECTION_REGIONALE = 1L;
    private static final Long UPDATED_ID_DIRECTION_REGIONALE = 2L;

    private static final Long DEFAULT_ID_FOURNISSEUR = 1L;
    private static final Long UPDATED_ID_FOURNISSEUR = 2L;

    private static final String DEFAULT_STATUT_PIECE_SAP = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_PIECE_SAP = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/piecesaps";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private PIECESAPRepository pIECESAPRepository;

    @Autowired
    private PIECESAPMapper pIECESAPMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPIECESAPMockMvc;

    private PIECESAP pIECESAP;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PIECESAP createEntity(EntityManager em) {
        PIECESAP pIECESAP = new PIECESAP()
            .idDLC(DEFAULT_ID_DLC)
            .idDirectionRegionale(DEFAULT_ID_DIRECTION_REGIONALE)
            .idFournisseur(DEFAULT_ID_FOURNISSEUR)
            .statutPieceSAP(DEFAULT_STATUT_PIECE_SAP)
            .libelle(DEFAULT_LIBELLE);
        return pIECESAP;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PIECESAP createUpdatedEntity(EntityManager em) {
        PIECESAP pIECESAP = new PIECESAP()
            .idDLC(UPDATED_ID_DLC)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .statutPieceSAP(UPDATED_STATUT_PIECE_SAP)
            .libelle(UPDATED_LIBELLE);
        return pIECESAP;
    }

    @BeforeEach
    public void initTest() {
        pIECESAP = createEntity(em);
    }

    @Test
    @Transactional
    void createPIECESAP() throws Exception {
        int databaseSizeBeforeCreate = pIECESAPRepository.findAll().size();
        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);
        restPIECESAPMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO)))
            .andExpect(status().isCreated());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeCreate + 1);
        PIECESAP testPIECESAP = pIECESAPList.get(pIECESAPList.size() - 1);
        assertThat(testPIECESAP.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
        assertThat(testPIECESAP.getIdDirectionRegionale()).isEqualTo(DEFAULT_ID_DIRECTION_REGIONALE);
        assertThat(testPIECESAP.getIdFournisseur()).isEqualTo(DEFAULT_ID_FOURNISSEUR);
        assertThat(testPIECESAP.getStatutPieceSAP()).isEqualTo(DEFAULT_STATUT_PIECE_SAP);
        assertThat(testPIECESAP.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    void createPIECESAPWithExistingId() throws Exception {
        // Create the PIECESAP with an existing ID
        pIECESAP.setId(1L);
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        int databaseSizeBeforeCreate = pIECESAPRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPIECESAPMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllPIECESAPS() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        // Get all the pIECESAPList
        restPIECESAPMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pIECESAP.getId().intValue())))
            .andExpect(jsonPath("$.[*].idDLC").value(hasItem(DEFAULT_ID_DLC.intValue())))
            .andExpect(jsonPath("$.[*].idDirectionRegionale").value(hasItem(DEFAULT_ID_DIRECTION_REGIONALE.intValue())))
            .andExpect(jsonPath("$.[*].idFournisseur").value(hasItem(DEFAULT_ID_FOURNISSEUR.intValue())))
            .andExpect(jsonPath("$.[*].statutPieceSAP").value(hasItem(DEFAULT_STATUT_PIECE_SAP)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)));
    }

    @Test
    @Transactional
    void getPIECESAP() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        // Get the pIECESAP
        restPIECESAPMockMvc
            .perform(get(ENTITY_API_URL_ID, pIECESAP.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pIECESAP.getId().intValue()))
            .andExpect(jsonPath("$.idDLC").value(DEFAULT_ID_DLC.intValue()))
            .andExpect(jsonPath("$.idDirectionRegionale").value(DEFAULT_ID_DIRECTION_REGIONALE.intValue()))
            .andExpect(jsonPath("$.idFournisseur").value(DEFAULT_ID_FOURNISSEUR.intValue()))
            .andExpect(jsonPath("$.statutPieceSAP").value(DEFAULT_STATUT_PIECE_SAP))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE));
    }

    @Test
    @Transactional
    void getNonExistingPIECESAP() throws Exception {
        // Get the pIECESAP
        restPIECESAPMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewPIECESAP() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();

        // Update the pIECESAP
        PIECESAP updatedPIECESAP = pIECESAPRepository.findById(pIECESAP.getId()).get();
        // Disconnect from session so that the updates on updatedPIECESAP are not directly saved in db
        em.detach(updatedPIECESAP);
        updatedPIECESAP
            .idDLC(UPDATED_ID_DLC)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .statutPieceSAP(UPDATED_STATUT_PIECE_SAP)
            .libelle(UPDATED_LIBELLE);
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(updatedPIECESAP);

        restPIECESAPMockMvc
            .perform(
                put(ENTITY_API_URL_ID, pIECESAPDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isOk());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
        PIECESAP testPIECESAP = pIECESAPList.get(pIECESAPList.size() - 1);
        assertThat(testPIECESAP.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testPIECESAP.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
        assertThat(testPIECESAP.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testPIECESAP.getStatutPieceSAP()).isEqualTo(UPDATED_STATUT_PIECE_SAP);
        assertThat(testPIECESAP.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    void putNonExistingPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(
                put(ENTITY_API_URL_ID, pIECESAPDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePIECESAPWithPatch() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();

        // Update the pIECESAP using partial update
        PIECESAP partialUpdatedPIECESAP = new PIECESAP();
        partialUpdatedPIECESAP.setId(pIECESAP.getId());

        partialUpdatedPIECESAP
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .libelle(UPDATED_LIBELLE);

        restPIECESAPMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPIECESAP.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPIECESAP))
            )
            .andExpect(status().isOk());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
        PIECESAP testPIECESAP = pIECESAPList.get(pIECESAPList.size() - 1);
        assertThat(testPIECESAP.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
        assertThat(testPIECESAP.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
        assertThat(testPIECESAP.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testPIECESAP.getStatutPieceSAP()).isEqualTo(DEFAULT_STATUT_PIECE_SAP);
        assertThat(testPIECESAP.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    void fullUpdatePIECESAPWithPatch() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();

        // Update the pIECESAP using partial update
        PIECESAP partialUpdatedPIECESAP = new PIECESAP();
        partialUpdatedPIECESAP.setId(pIECESAP.getId());

        partialUpdatedPIECESAP
            .idDLC(UPDATED_ID_DLC)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .statutPieceSAP(UPDATED_STATUT_PIECE_SAP)
            .libelle(UPDATED_LIBELLE);

        restPIECESAPMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPIECESAP.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedPIECESAP))
            )
            .andExpect(status().isOk());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
        PIECESAP testPIECESAP = pIECESAPList.get(pIECESAPList.size() - 1);
        assertThat(testPIECESAP.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testPIECESAP.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
        assertThat(testPIECESAP.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testPIECESAP.getStatutPieceSAP()).isEqualTo(UPDATED_STATUT_PIECE_SAP);
        assertThat(testPIECESAP.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    void patchNonExistingPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, pIECESAPDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPIECESAP() throws Exception {
        int databaseSizeBeforeUpdate = pIECESAPRepository.findAll().size();
        pIECESAP.setId(count.incrementAndGet());

        // Create the PIECESAP
        PIECESAPDTO pIECESAPDTO = pIECESAPMapper.toDto(pIECESAP);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPIECESAPMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(pIECESAPDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the PIECESAP in the database
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePIECESAP() throws Exception {
        // Initialize the database
        pIECESAPRepository.saveAndFlush(pIECESAP);

        int databaseSizeBeforeDelete = pIECESAPRepository.findAll().size();

        // Delete the pIECESAP
        restPIECESAPMockMvc
            .perform(delete(ENTITY_API_URL_ID, pIECESAP.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PIECESAP> pIECESAPList = pIECESAPRepository.findAll();
        assertThat(pIECESAPList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
