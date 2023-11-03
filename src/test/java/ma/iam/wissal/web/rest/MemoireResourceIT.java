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
import ma.iam.wissal.domain.Memoire;
import ma.iam.wissal.repository.MemoireRepository;
import ma.iam.wissal.service.dto.MemoireDTO;
import ma.iam.wissal.service.mapper.MemoireMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link MemoireResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MemoireResourceIT {

    private static final String DEFAULT_CODE_MEMOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_MEMOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_INTITULE_MEMOIRE = "AAAAAAAAAA";
    private static final String UPDATED_INTITULE_MEMOIRE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_MEMOIRE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_MEMOIRE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_ID_FOURNISSEUR = 1L;
    private static final Long UPDATED_ID_FOURNISSEUR = 2L;

    private static final Long DEFAULT_ID_DLC = 1L;
    private static final Long UPDATED_ID_DLC = 2L;

    private static final Long DEFAULT_ID_VILLE = 1L;
    private static final Long UPDATED_ID_VILLE = 2L;

    private static final Double DEFAULT_MONTANT_TTC = 1D;
    private static final Double UPDATED_MONTANT_TTC = 2D;

    private static final Double DEFAULT_MONTANT_TVA_7 = 1D;
    private static final Double UPDATED_MONTANT_TVA_7 = 2D;

    private static final Double DEFAULT_MONTANT_HT_7 = 1D;
    private static final Double UPDATED_MONTANT_HT_7 = 2D;

    private static final Double DEFAULT_MONTANT_TVA_14 = 1D;
    private static final Double UPDATED_MONTANT_TVA_14 = 2D;

    private static final Double DEFAULT_MONTANT_HT_14 = 1D;
    private static final Double UPDATED_MONTANT_HT_14 = 2D;

    private static final Double DEFAULT_MONTANT_TVA_20 = 1D;
    private static final Double UPDATED_MONTANT_TVA_20 = 2D;

    private static final Double DEFAULT_MONTANT_HT_20 = 1D;
    private static final Double UPDATED_MONTANT_HT_20 = 2D;

    private static final Double DEFAULT_MONTANT_TVA_MANUE = 1D;
    private static final Double UPDATED_MONTANT_TVA_MANUE = 2D;

    private static final Double DEFAULT_DIVERSES_TAXES = 1D;
    private static final Double UPDATED_DIVERSES_TAXES = 2D;

    private static final LocalDate DEFAULT_DATE_COMPTABLE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_COMPTABLE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_NUM_PIECE_SAP = 1L;
    private static final Long UPDATED_NUM_PIECE_SAP = 2L;

    private static final Long DEFAULT_NUM_OV = 1L;
    private static final Long UPDATED_NUM_OV = 2L;

    private static final LocalDate DEFAULT_DATE_COMPTABLE_REELLE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_COMPTABLE_REELLE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_OV = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OV = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STATUT_MEMOIRE = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_MEMOIRE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_VALIDATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_VALIDATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_REJET = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_REJET = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_COMPTABILISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_COMPTABILISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_PAIEMENT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PAIEMENT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_DEVALIDATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEVALIDATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_MODIFICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_MODIFICATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MOTIF_REJET = "AAAAAAAAAA";
    private static final String UPDATED_MOTIF_REJET = "BBBBBBBBBB";

    private static final Long DEFAULT_ID_USER_CREATION = 1L;
    private static final Long UPDATED_ID_USER_CREATION = 2L;

    private static final Long DEFAULT_ID_USER_VALIDATION = 1L;
    private static final Long UPDATED_ID_USER_VALIDATION = 2L;

    private static final Long DEFAULT_ID_USER_REJET = 1L;
    private static final Long UPDATED_ID_USER_REJET = 2L;

    private static final Long DEFAULT_ID_USER_COMPTABILISATION = 1L;
    private static final Long UPDATED_ID_USER_COMPTABILISATION = 2L;

    private static final Long DEFAULT_ID_USER_PAIEMENT = 1L;
    private static final Long UPDATED_ID_USER_PAIEMENT = 2L;

    private static final Long DEFAULT_ID_USER_DEVALIDATION = 1L;
    private static final Long UPDATED_ID_USER_DEVALIDATION = 2L;

    private static final Long DEFAULT_ID_USER_MODIFICATION = 1L;
    private static final Long UPDATED_ID_USER_MODIFICATION = 2L;

    private static final String ENTITY_API_URL = "/api/memoires";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MemoireRepository memoireRepository;

    @Autowired
    private MemoireMapper memoireMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMemoireMockMvc;

    private Memoire memoire;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Memoire createEntity(EntityManager em) {
        Memoire memoire = new Memoire()
            .codeMemoire(DEFAULT_CODE_MEMOIRE)
            .intituleMemoire(DEFAULT_INTITULE_MEMOIRE)
            .dateMemoire(DEFAULT_DATE_MEMOIRE)
            .idFournisseur(DEFAULT_ID_FOURNISSEUR)
            .idDLC(DEFAULT_ID_DLC)
            .idVille(DEFAULT_ID_VILLE)
            .montantTTC(DEFAULT_MONTANT_TTC)
            .montantTVA7(DEFAULT_MONTANT_TVA_7)
            .montantHT7(DEFAULT_MONTANT_HT_7)
            .montantTVA14(DEFAULT_MONTANT_TVA_14)
            .montantHT14(DEFAULT_MONTANT_HT_14)
            .montantTVA20(DEFAULT_MONTANT_TVA_20)
            .montantHT20(DEFAULT_MONTANT_HT_20)
            .montantTvaManue(DEFAULT_MONTANT_TVA_MANUE)
            .diversesTaxes(DEFAULT_DIVERSES_TAXES)
            .dateComptable(DEFAULT_DATE_COMPTABLE)
            .numPieceSap(DEFAULT_NUM_PIECE_SAP)
            .numOv(DEFAULT_NUM_OV)
            .dateComptableReelle(DEFAULT_DATE_COMPTABLE_REELLE)
            .dateOV(DEFAULT_DATE_OV)
            .statutMemoire(DEFAULT_STATUT_MEMOIRE)
            .dateCreation(DEFAULT_DATE_CREATION)
            .dateValidation(DEFAULT_DATE_VALIDATION)
            .dateRejet(DEFAULT_DATE_REJET)
            .dateComptabilisation(DEFAULT_DATE_COMPTABILISATION)
            .datePaiement(DEFAULT_DATE_PAIEMENT)
            .dateDevalidation(DEFAULT_DATE_DEVALIDATION)
            .dateModification(DEFAULT_DATE_MODIFICATION)
            .motifRejet(DEFAULT_MOTIF_REJET)
            .idUserCreation(DEFAULT_ID_USER_CREATION)
            .idUserValidation(DEFAULT_ID_USER_VALIDATION)
            .idUserRejet(DEFAULT_ID_USER_REJET)
            .idUserComptabilisation(DEFAULT_ID_USER_COMPTABILISATION)
            .idUserPaiement(DEFAULT_ID_USER_PAIEMENT)
            .idUserDevalidation(DEFAULT_ID_USER_DEVALIDATION)
            .idUserModification(DEFAULT_ID_USER_MODIFICATION);
        return memoire;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Memoire createUpdatedEntity(EntityManager em) {
        Memoire memoire = new Memoire()
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .intituleMemoire(UPDATED_INTITULE_MEMOIRE)
            .dateMemoire(UPDATED_DATE_MEMOIRE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES)
            .dateComptable(UPDATED_DATE_COMPTABLE)
            .numPieceSap(UPDATED_NUM_PIECE_SAP)
            .numOv(UPDATED_NUM_OV)
            .dateComptableReelle(UPDATED_DATE_COMPTABLE_REELLE)
            .dateOV(UPDATED_DATE_OV)
            .statutMemoire(UPDATED_STATUT_MEMOIRE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .dateComptabilisation(UPDATED_DATE_COMPTABILISATION)
            .datePaiement(UPDATED_DATE_PAIEMENT)
            .dateDevalidation(UPDATED_DATE_DEVALIDATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserComptabilisation(UPDATED_ID_USER_COMPTABILISATION)
            .idUserPaiement(UPDATED_ID_USER_PAIEMENT)
            .idUserDevalidation(UPDATED_ID_USER_DEVALIDATION)
            .idUserModification(UPDATED_ID_USER_MODIFICATION);
        return memoire;
    }

    @BeforeEach
    public void initTest() {
        memoire = createEntity(em);
    }

    @Test
    @Transactional
    void createMemoire() throws Exception {
        int databaseSizeBeforeCreate = memoireRepository.findAll().size();
        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);
        restMemoireMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDTO)))
            .andExpect(status().isCreated());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeCreate + 1);
        Memoire testMemoire = memoireList.get(memoireList.size() - 1);
        assertThat(testMemoire.getCodeMemoire()).isEqualTo(DEFAULT_CODE_MEMOIRE);
        assertThat(testMemoire.getIntituleMemoire()).isEqualTo(DEFAULT_INTITULE_MEMOIRE);
        assertThat(testMemoire.getDateMemoire()).isEqualTo(DEFAULT_DATE_MEMOIRE);
        assertThat(testMemoire.getIdFournisseur()).isEqualTo(DEFAULT_ID_FOURNISSEUR);
        assertThat(testMemoire.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
        assertThat(testMemoire.getIdVille()).isEqualTo(DEFAULT_ID_VILLE);
        assertThat(testMemoire.getMontantTTC()).isEqualTo(DEFAULT_MONTANT_TTC);
        assertThat(testMemoire.getMontantTVA7()).isEqualTo(DEFAULT_MONTANT_TVA_7);
        assertThat(testMemoire.getMontantHT7()).isEqualTo(DEFAULT_MONTANT_HT_7);
        assertThat(testMemoire.getMontantTVA14()).isEqualTo(DEFAULT_MONTANT_TVA_14);
        assertThat(testMemoire.getMontantHT14()).isEqualTo(DEFAULT_MONTANT_HT_14);
        assertThat(testMemoire.getMontantTVA20()).isEqualTo(DEFAULT_MONTANT_TVA_20);
        assertThat(testMemoire.getMontantHT20()).isEqualTo(DEFAULT_MONTANT_HT_20);
        assertThat(testMemoire.getMontantTvaManue()).isEqualTo(DEFAULT_MONTANT_TVA_MANUE);
        assertThat(testMemoire.getDiversesTaxes()).isEqualTo(DEFAULT_DIVERSES_TAXES);
        assertThat(testMemoire.getDateComptable()).isEqualTo(DEFAULT_DATE_COMPTABLE);
        assertThat(testMemoire.getNumPieceSap()).isEqualTo(DEFAULT_NUM_PIECE_SAP);
        assertThat(testMemoire.getNumOv()).isEqualTo(DEFAULT_NUM_OV);
        assertThat(testMemoire.getDateComptableReelle()).isEqualTo(DEFAULT_DATE_COMPTABLE_REELLE);
        assertThat(testMemoire.getDateOV()).isEqualTo(DEFAULT_DATE_OV);
        assertThat(testMemoire.getStatutMemoire()).isEqualTo(DEFAULT_STATUT_MEMOIRE);
        assertThat(testMemoire.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testMemoire.getDateValidation()).isEqualTo(DEFAULT_DATE_VALIDATION);
        assertThat(testMemoire.getDateRejet()).isEqualTo(DEFAULT_DATE_REJET);
        assertThat(testMemoire.getDateComptabilisation()).isEqualTo(DEFAULT_DATE_COMPTABILISATION);
        assertThat(testMemoire.getDatePaiement()).isEqualTo(DEFAULT_DATE_PAIEMENT);
        assertThat(testMemoire.getDateDevalidation()).isEqualTo(DEFAULT_DATE_DEVALIDATION);
        assertThat(testMemoire.getDateModification()).isEqualTo(DEFAULT_DATE_MODIFICATION);
        assertThat(testMemoire.getMotifRejet()).isEqualTo(DEFAULT_MOTIF_REJET);
        assertThat(testMemoire.getIdUserCreation()).isEqualTo(DEFAULT_ID_USER_CREATION);
        assertThat(testMemoire.getIdUserValidation()).isEqualTo(DEFAULT_ID_USER_VALIDATION);
        assertThat(testMemoire.getIdUserRejet()).isEqualTo(DEFAULT_ID_USER_REJET);
        assertThat(testMemoire.getIdUserComptabilisation()).isEqualTo(DEFAULT_ID_USER_COMPTABILISATION);
        assertThat(testMemoire.getIdUserPaiement()).isEqualTo(DEFAULT_ID_USER_PAIEMENT);
        assertThat(testMemoire.getIdUserDevalidation()).isEqualTo(DEFAULT_ID_USER_DEVALIDATION);
        assertThat(testMemoire.getIdUserModification()).isEqualTo(DEFAULT_ID_USER_MODIFICATION);
    }

    @Test
    @Transactional
    void createMemoireWithExistingId() throws Exception {
        // Create the Memoire with an existing ID
        memoire.setId(1L);
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        int databaseSizeBeforeCreate = memoireRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restMemoireMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllMemoires() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        // Get all the memoireList
        restMemoireMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(memoire.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeMemoire").value(hasItem(DEFAULT_CODE_MEMOIRE)))
            .andExpect(jsonPath("$.[*].intituleMemoire").value(hasItem(DEFAULT_INTITULE_MEMOIRE)))
            .andExpect(jsonPath("$.[*].dateMemoire").value(hasItem(DEFAULT_DATE_MEMOIRE.toString())))
            .andExpect(jsonPath("$.[*].idFournisseur").value(hasItem(DEFAULT_ID_FOURNISSEUR.intValue())))
            .andExpect(jsonPath("$.[*].idDLC").value(hasItem(DEFAULT_ID_DLC.intValue())))
            .andExpect(jsonPath("$.[*].idVille").value(hasItem(DEFAULT_ID_VILLE.intValue())))
            .andExpect(jsonPath("$.[*].montantTTC").value(hasItem(DEFAULT_MONTANT_TTC.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTVA7").value(hasItem(DEFAULT_MONTANT_TVA_7.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT7").value(hasItem(DEFAULT_MONTANT_HT_7.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTVA14").value(hasItem(DEFAULT_MONTANT_TVA_14.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT14").value(hasItem(DEFAULT_MONTANT_HT_14.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTVA20").value(hasItem(DEFAULT_MONTANT_TVA_20.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT20").value(hasItem(DEFAULT_MONTANT_HT_20.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTvaManue").value(hasItem(DEFAULT_MONTANT_TVA_MANUE.doubleValue())))
            .andExpect(jsonPath("$.[*].diversesTaxes").value(hasItem(DEFAULT_DIVERSES_TAXES.doubleValue())))
            .andExpect(jsonPath("$.[*].dateComptable").value(hasItem(DEFAULT_DATE_COMPTABLE.toString())))
            .andExpect(jsonPath("$.[*].numPieceSap").value(hasItem(DEFAULT_NUM_PIECE_SAP.intValue())))
            .andExpect(jsonPath("$.[*].numOv").value(hasItem(DEFAULT_NUM_OV.intValue())))
            .andExpect(jsonPath("$.[*].dateComptableReelle").value(hasItem(DEFAULT_DATE_COMPTABLE_REELLE.toString())))
            .andExpect(jsonPath("$.[*].dateOV").value(hasItem(DEFAULT_DATE_OV.toString())))
            .andExpect(jsonPath("$.[*].statutMemoire").value(hasItem(DEFAULT_STATUT_MEMOIRE)))
            .andExpect(jsonPath("$.[*].dateCreation").value(hasItem(DEFAULT_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].dateValidation").value(hasItem(DEFAULT_DATE_VALIDATION.toString())))
            .andExpect(jsonPath("$.[*].dateRejet").value(hasItem(DEFAULT_DATE_REJET.toString())))
            .andExpect(jsonPath("$.[*].dateComptabilisation").value(hasItem(DEFAULT_DATE_COMPTABILISATION.toString())))
            .andExpect(jsonPath("$.[*].datePaiement").value(hasItem(DEFAULT_DATE_PAIEMENT.toString())))
            .andExpect(jsonPath("$.[*].dateDevalidation").value(hasItem(DEFAULT_DATE_DEVALIDATION.toString())))
            .andExpect(jsonPath("$.[*].dateModification").value(hasItem(DEFAULT_DATE_MODIFICATION.toString())))
            .andExpect(jsonPath("$.[*].motifRejet").value(hasItem(DEFAULT_MOTIF_REJET)))
            .andExpect(jsonPath("$.[*].idUserCreation").value(hasItem(DEFAULT_ID_USER_CREATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserValidation").value(hasItem(DEFAULT_ID_USER_VALIDATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserRejet").value(hasItem(DEFAULT_ID_USER_REJET.intValue())))
            .andExpect(jsonPath("$.[*].idUserComptabilisation").value(hasItem(DEFAULT_ID_USER_COMPTABILISATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserPaiement").value(hasItem(DEFAULT_ID_USER_PAIEMENT.intValue())))
            .andExpect(jsonPath("$.[*].idUserDevalidation").value(hasItem(DEFAULT_ID_USER_DEVALIDATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserModification").value(hasItem(DEFAULT_ID_USER_MODIFICATION.intValue())));
    }

    @Test
    @Transactional
    void getMemoire() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        // Get the memoire
        restMemoireMockMvc
            .perform(get(ENTITY_API_URL_ID, memoire.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(memoire.getId().intValue()))
            .andExpect(jsonPath("$.codeMemoire").value(DEFAULT_CODE_MEMOIRE))
            .andExpect(jsonPath("$.intituleMemoire").value(DEFAULT_INTITULE_MEMOIRE))
            .andExpect(jsonPath("$.dateMemoire").value(DEFAULT_DATE_MEMOIRE.toString()))
            .andExpect(jsonPath("$.idFournisseur").value(DEFAULT_ID_FOURNISSEUR.intValue()))
            .andExpect(jsonPath("$.idDLC").value(DEFAULT_ID_DLC.intValue()))
            .andExpect(jsonPath("$.idVille").value(DEFAULT_ID_VILLE.intValue()))
            .andExpect(jsonPath("$.montantTTC").value(DEFAULT_MONTANT_TTC.doubleValue()))
            .andExpect(jsonPath("$.montantTVA7").value(DEFAULT_MONTANT_TVA_7.doubleValue()))
            .andExpect(jsonPath("$.montantHT7").value(DEFAULT_MONTANT_HT_7.doubleValue()))
            .andExpect(jsonPath("$.montantTVA14").value(DEFAULT_MONTANT_TVA_14.doubleValue()))
            .andExpect(jsonPath("$.montantHT14").value(DEFAULT_MONTANT_HT_14.doubleValue()))
            .andExpect(jsonPath("$.montantTVA20").value(DEFAULT_MONTANT_TVA_20.doubleValue()))
            .andExpect(jsonPath("$.montantHT20").value(DEFAULT_MONTANT_HT_20.doubleValue()))
            .andExpect(jsonPath("$.montantTvaManue").value(DEFAULT_MONTANT_TVA_MANUE.doubleValue()))
            .andExpect(jsonPath("$.diversesTaxes").value(DEFAULT_DIVERSES_TAXES.doubleValue()))
            .andExpect(jsonPath("$.dateComptable").value(DEFAULT_DATE_COMPTABLE.toString()))
            .andExpect(jsonPath("$.numPieceSap").value(DEFAULT_NUM_PIECE_SAP.intValue()))
            .andExpect(jsonPath("$.numOv").value(DEFAULT_NUM_OV.intValue()))
            .andExpect(jsonPath("$.dateComptableReelle").value(DEFAULT_DATE_COMPTABLE_REELLE.toString()))
            .andExpect(jsonPath("$.dateOV").value(DEFAULT_DATE_OV.toString()))
            .andExpect(jsonPath("$.statutMemoire").value(DEFAULT_STATUT_MEMOIRE))
            .andExpect(jsonPath("$.dateCreation").value(DEFAULT_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.dateValidation").value(DEFAULT_DATE_VALIDATION.toString()))
            .andExpect(jsonPath("$.dateRejet").value(DEFAULT_DATE_REJET.toString()))
            .andExpect(jsonPath("$.dateComptabilisation").value(DEFAULT_DATE_COMPTABILISATION.toString()))
            .andExpect(jsonPath("$.datePaiement").value(DEFAULT_DATE_PAIEMENT.toString()))
            .andExpect(jsonPath("$.dateDevalidation").value(DEFAULT_DATE_DEVALIDATION.toString()))
            .andExpect(jsonPath("$.dateModification").value(DEFAULT_DATE_MODIFICATION.toString()))
            .andExpect(jsonPath("$.motifRejet").value(DEFAULT_MOTIF_REJET))
            .andExpect(jsonPath("$.idUserCreation").value(DEFAULT_ID_USER_CREATION.intValue()))
            .andExpect(jsonPath("$.idUserValidation").value(DEFAULT_ID_USER_VALIDATION.intValue()))
            .andExpect(jsonPath("$.idUserRejet").value(DEFAULT_ID_USER_REJET.intValue()))
            .andExpect(jsonPath("$.idUserComptabilisation").value(DEFAULT_ID_USER_COMPTABILISATION.intValue()))
            .andExpect(jsonPath("$.idUserPaiement").value(DEFAULT_ID_USER_PAIEMENT.intValue()))
            .andExpect(jsonPath("$.idUserDevalidation").value(DEFAULT_ID_USER_DEVALIDATION.intValue()))
            .andExpect(jsonPath("$.idUserModification").value(DEFAULT_ID_USER_MODIFICATION.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingMemoire() throws Exception {
        // Get the memoire
        restMemoireMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewMemoire() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();

        // Update the memoire
        Memoire updatedMemoire = memoireRepository.findById(memoire.getId()).get();
        // Disconnect from session so that the updates on updatedMemoire are not directly saved in db
        em.detach(updatedMemoire);
        updatedMemoire
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .intituleMemoire(UPDATED_INTITULE_MEMOIRE)
            .dateMemoire(UPDATED_DATE_MEMOIRE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES)
            .dateComptable(UPDATED_DATE_COMPTABLE)
            .numPieceSap(UPDATED_NUM_PIECE_SAP)
            .numOv(UPDATED_NUM_OV)
            .dateComptableReelle(UPDATED_DATE_COMPTABLE_REELLE)
            .dateOV(UPDATED_DATE_OV)
            .statutMemoire(UPDATED_STATUT_MEMOIRE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .dateComptabilisation(UPDATED_DATE_COMPTABILISATION)
            .datePaiement(UPDATED_DATE_PAIEMENT)
            .dateDevalidation(UPDATED_DATE_DEVALIDATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserComptabilisation(UPDATED_ID_USER_COMPTABILISATION)
            .idUserPaiement(UPDATED_ID_USER_PAIEMENT)
            .idUserDevalidation(UPDATED_ID_USER_DEVALIDATION)
            .idUserModification(UPDATED_ID_USER_MODIFICATION);
        MemoireDTO memoireDTO = memoireMapper.toDto(updatedMemoire);

        restMemoireMockMvc
            .perform(
                put(ENTITY_API_URL_ID, memoireDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isOk());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
        Memoire testMemoire = memoireList.get(memoireList.size() - 1);
        assertThat(testMemoire.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoire.getIntituleMemoire()).isEqualTo(UPDATED_INTITULE_MEMOIRE);
        assertThat(testMemoire.getDateMemoire()).isEqualTo(UPDATED_DATE_MEMOIRE);
        assertThat(testMemoire.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testMemoire.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testMemoire.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testMemoire.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testMemoire.getMontantTVA7()).isEqualTo(UPDATED_MONTANT_TVA_7);
        assertThat(testMemoire.getMontantHT7()).isEqualTo(UPDATED_MONTANT_HT_7);
        assertThat(testMemoire.getMontantTVA14()).isEqualTo(UPDATED_MONTANT_TVA_14);
        assertThat(testMemoire.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testMemoire.getMontantTVA20()).isEqualTo(UPDATED_MONTANT_TVA_20);
        assertThat(testMemoire.getMontantHT20()).isEqualTo(UPDATED_MONTANT_HT_20);
        assertThat(testMemoire.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testMemoire.getDiversesTaxes()).isEqualTo(UPDATED_DIVERSES_TAXES);
        assertThat(testMemoire.getDateComptable()).isEqualTo(UPDATED_DATE_COMPTABLE);
        assertThat(testMemoire.getNumPieceSap()).isEqualTo(UPDATED_NUM_PIECE_SAP);
        assertThat(testMemoire.getNumOv()).isEqualTo(UPDATED_NUM_OV);
        assertThat(testMemoire.getDateComptableReelle()).isEqualTo(UPDATED_DATE_COMPTABLE_REELLE);
        assertThat(testMemoire.getDateOV()).isEqualTo(UPDATED_DATE_OV);
        assertThat(testMemoire.getStatutMemoire()).isEqualTo(UPDATED_STATUT_MEMOIRE);
        assertThat(testMemoire.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testMemoire.getDateValidation()).isEqualTo(UPDATED_DATE_VALIDATION);
        assertThat(testMemoire.getDateRejet()).isEqualTo(UPDATED_DATE_REJET);
        assertThat(testMemoire.getDateComptabilisation()).isEqualTo(UPDATED_DATE_COMPTABILISATION);
        assertThat(testMemoire.getDatePaiement()).isEqualTo(UPDATED_DATE_PAIEMENT);
        assertThat(testMemoire.getDateDevalidation()).isEqualTo(UPDATED_DATE_DEVALIDATION);
        assertThat(testMemoire.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testMemoire.getMotifRejet()).isEqualTo(UPDATED_MOTIF_REJET);
        assertThat(testMemoire.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testMemoire.getIdUserValidation()).isEqualTo(UPDATED_ID_USER_VALIDATION);
        assertThat(testMemoire.getIdUserRejet()).isEqualTo(UPDATED_ID_USER_REJET);
        assertThat(testMemoire.getIdUserComptabilisation()).isEqualTo(UPDATED_ID_USER_COMPTABILISATION);
        assertThat(testMemoire.getIdUserPaiement()).isEqualTo(UPDATED_ID_USER_PAIEMENT);
        assertThat(testMemoire.getIdUserDevalidation()).isEqualTo(UPDATED_ID_USER_DEVALIDATION);
        assertThat(testMemoire.getIdUserModification()).isEqualTo(UPDATED_ID_USER_MODIFICATION);
    }

    @Test
    @Transactional
    void putNonExistingMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(
                put(ENTITY_API_URL_ID, memoireDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(memoireDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateMemoireWithPatch() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();

        // Update the memoire using partial update
        Memoire partialUpdatedMemoire = new Memoire();
        partialUpdatedMemoire.setId(memoire.getId());

        partialUpdatedMemoire
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .dateMemoire(UPDATED_DATE_MEMOIRE)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .dateComptable(UPDATED_DATE_COMPTABLE)
            .dateOV(UPDATED_DATE_OV)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateDevalidation(UPDATED_DATE_DEVALIDATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserComptabilisation(UPDATED_ID_USER_COMPTABILISATION)
            .idUserDevalidation(UPDATED_ID_USER_DEVALIDATION);

        restMemoireMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMemoire.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMemoire))
            )
            .andExpect(status().isOk());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
        Memoire testMemoire = memoireList.get(memoireList.size() - 1);
        assertThat(testMemoire.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoire.getIntituleMemoire()).isEqualTo(DEFAULT_INTITULE_MEMOIRE);
        assertThat(testMemoire.getDateMemoire()).isEqualTo(UPDATED_DATE_MEMOIRE);
        assertThat(testMemoire.getIdFournisseur()).isEqualTo(DEFAULT_ID_FOURNISSEUR);
        assertThat(testMemoire.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testMemoire.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testMemoire.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testMemoire.getMontantTVA7()).isEqualTo(DEFAULT_MONTANT_TVA_7);
        assertThat(testMemoire.getMontantHT7()).isEqualTo(DEFAULT_MONTANT_HT_7);
        assertThat(testMemoire.getMontantTVA14()).isEqualTo(UPDATED_MONTANT_TVA_14);
        assertThat(testMemoire.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testMemoire.getMontantTVA20()).isEqualTo(DEFAULT_MONTANT_TVA_20);
        assertThat(testMemoire.getMontantHT20()).isEqualTo(DEFAULT_MONTANT_HT_20);
        assertThat(testMemoire.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testMemoire.getDiversesTaxes()).isEqualTo(DEFAULT_DIVERSES_TAXES);
        assertThat(testMemoire.getDateComptable()).isEqualTo(UPDATED_DATE_COMPTABLE);
        assertThat(testMemoire.getNumPieceSap()).isEqualTo(DEFAULT_NUM_PIECE_SAP);
        assertThat(testMemoire.getNumOv()).isEqualTo(DEFAULT_NUM_OV);
        assertThat(testMemoire.getDateComptableReelle()).isEqualTo(DEFAULT_DATE_COMPTABLE_REELLE);
        assertThat(testMemoire.getDateOV()).isEqualTo(UPDATED_DATE_OV);
        assertThat(testMemoire.getStatutMemoire()).isEqualTo(DEFAULT_STATUT_MEMOIRE);
        assertThat(testMemoire.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testMemoire.getDateValidation()).isEqualTo(UPDATED_DATE_VALIDATION);
        assertThat(testMemoire.getDateRejet()).isEqualTo(DEFAULT_DATE_REJET);
        assertThat(testMemoire.getDateComptabilisation()).isEqualTo(DEFAULT_DATE_COMPTABILISATION);
        assertThat(testMemoire.getDatePaiement()).isEqualTo(DEFAULT_DATE_PAIEMENT);
        assertThat(testMemoire.getDateDevalidation()).isEqualTo(UPDATED_DATE_DEVALIDATION);
        assertThat(testMemoire.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testMemoire.getMotifRejet()).isEqualTo(UPDATED_MOTIF_REJET);
        assertThat(testMemoire.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testMemoire.getIdUserValidation()).isEqualTo(DEFAULT_ID_USER_VALIDATION);
        assertThat(testMemoire.getIdUserRejet()).isEqualTo(DEFAULT_ID_USER_REJET);
        assertThat(testMemoire.getIdUserComptabilisation()).isEqualTo(UPDATED_ID_USER_COMPTABILISATION);
        assertThat(testMemoire.getIdUserPaiement()).isEqualTo(DEFAULT_ID_USER_PAIEMENT);
        assertThat(testMemoire.getIdUserDevalidation()).isEqualTo(UPDATED_ID_USER_DEVALIDATION);
        assertThat(testMemoire.getIdUserModification()).isEqualTo(DEFAULT_ID_USER_MODIFICATION);
    }

    @Test
    @Transactional
    void fullUpdateMemoireWithPatch() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();

        // Update the memoire using partial update
        Memoire partialUpdatedMemoire = new Memoire();
        partialUpdatedMemoire.setId(memoire.getId());

        partialUpdatedMemoire
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .intituleMemoire(UPDATED_INTITULE_MEMOIRE)
            .dateMemoire(UPDATED_DATE_MEMOIRE)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES)
            .dateComptable(UPDATED_DATE_COMPTABLE)
            .numPieceSap(UPDATED_NUM_PIECE_SAP)
            .numOv(UPDATED_NUM_OV)
            .dateComptableReelle(UPDATED_DATE_COMPTABLE_REELLE)
            .dateOV(UPDATED_DATE_OV)
            .statutMemoire(UPDATED_STATUT_MEMOIRE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .dateComptabilisation(UPDATED_DATE_COMPTABILISATION)
            .datePaiement(UPDATED_DATE_PAIEMENT)
            .dateDevalidation(UPDATED_DATE_DEVALIDATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserComptabilisation(UPDATED_ID_USER_COMPTABILISATION)
            .idUserPaiement(UPDATED_ID_USER_PAIEMENT)
            .idUserDevalidation(UPDATED_ID_USER_DEVALIDATION)
            .idUserModification(UPDATED_ID_USER_MODIFICATION);

        restMemoireMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedMemoire.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedMemoire))
            )
            .andExpect(status().isOk());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
        Memoire testMemoire = memoireList.get(memoireList.size() - 1);
        assertThat(testMemoire.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testMemoire.getIntituleMemoire()).isEqualTo(UPDATED_INTITULE_MEMOIRE);
        assertThat(testMemoire.getDateMemoire()).isEqualTo(UPDATED_DATE_MEMOIRE);
        assertThat(testMemoire.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testMemoire.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testMemoire.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testMemoire.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testMemoire.getMontantTVA7()).isEqualTo(UPDATED_MONTANT_TVA_7);
        assertThat(testMemoire.getMontantHT7()).isEqualTo(UPDATED_MONTANT_HT_7);
        assertThat(testMemoire.getMontantTVA14()).isEqualTo(UPDATED_MONTANT_TVA_14);
        assertThat(testMemoire.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testMemoire.getMontantTVA20()).isEqualTo(UPDATED_MONTANT_TVA_20);
        assertThat(testMemoire.getMontantHT20()).isEqualTo(UPDATED_MONTANT_HT_20);
        assertThat(testMemoire.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testMemoire.getDiversesTaxes()).isEqualTo(UPDATED_DIVERSES_TAXES);
        assertThat(testMemoire.getDateComptable()).isEqualTo(UPDATED_DATE_COMPTABLE);
        assertThat(testMemoire.getNumPieceSap()).isEqualTo(UPDATED_NUM_PIECE_SAP);
        assertThat(testMemoire.getNumOv()).isEqualTo(UPDATED_NUM_OV);
        assertThat(testMemoire.getDateComptableReelle()).isEqualTo(UPDATED_DATE_COMPTABLE_REELLE);
        assertThat(testMemoire.getDateOV()).isEqualTo(UPDATED_DATE_OV);
        assertThat(testMemoire.getStatutMemoire()).isEqualTo(UPDATED_STATUT_MEMOIRE);
        assertThat(testMemoire.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testMemoire.getDateValidation()).isEqualTo(UPDATED_DATE_VALIDATION);
        assertThat(testMemoire.getDateRejet()).isEqualTo(UPDATED_DATE_REJET);
        assertThat(testMemoire.getDateComptabilisation()).isEqualTo(UPDATED_DATE_COMPTABILISATION);
        assertThat(testMemoire.getDatePaiement()).isEqualTo(UPDATED_DATE_PAIEMENT);
        assertThat(testMemoire.getDateDevalidation()).isEqualTo(UPDATED_DATE_DEVALIDATION);
        assertThat(testMemoire.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testMemoire.getMotifRejet()).isEqualTo(UPDATED_MOTIF_REJET);
        assertThat(testMemoire.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testMemoire.getIdUserValidation()).isEqualTo(UPDATED_ID_USER_VALIDATION);
        assertThat(testMemoire.getIdUserRejet()).isEqualTo(UPDATED_ID_USER_REJET);
        assertThat(testMemoire.getIdUserComptabilisation()).isEqualTo(UPDATED_ID_USER_COMPTABILISATION);
        assertThat(testMemoire.getIdUserPaiement()).isEqualTo(UPDATED_ID_USER_PAIEMENT);
        assertThat(testMemoire.getIdUserDevalidation()).isEqualTo(UPDATED_ID_USER_DEVALIDATION);
        assertThat(testMemoire.getIdUserModification()).isEqualTo(UPDATED_ID_USER_MODIFICATION);
    }

    @Test
    @Transactional
    void patchNonExistingMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, memoireDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamMemoire() throws Exception {
        int databaseSizeBeforeUpdate = memoireRepository.findAll().size();
        memoire.setId(count.incrementAndGet());

        // Create the Memoire
        MemoireDTO memoireDTO = memoireMapper.toDto(memoire);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restMemoireMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(memoireDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Memoire in the database
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteMemoire() throws Exception {
        // Initialize the database
        memoireRepository.saveAndFlush(memoire);

        int databaseSizeBeforeDelete = memoireRepository.findAll().size();

        // Delete the memoire
        restMemoireMockMvc
            .perform(delete(ENTITY_API_URL_ID, memoire.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Memoire> memoireList = memoireRepository.findAll();
        assertThat(memoireList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
