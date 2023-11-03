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
import ma.iam.wissal.domain.Facture;
import ma.iam.wissal.repository.FactureRepository;
import ma.iam.wissal.service.dto.FactureDTO;
import ma.iam.wissal.service.mapper.FactureMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link FactureResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FactureResourceIT {

    private static final Long DEFAULT_ID_IOC = 1L;
    private static final Long UPDATED_ID_IOC = 2L;

    private static final Long DEFAULT_NUMERO_FACTURE = 1L;
    private static final Long UPDATED_NUMERO_FACTURE = 2L;

    private static final LocalDate DEFAULT_DATE_FACTURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FACTURE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CODE_MEMOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_MEMOIRE = "BBBBBBBBBB";

    private static final Long DEFAULT_ID_MEMOIRE = 1L;
    private static final Long UPDATED_ID_MEMOIRE = 2L;

    private static final Double DEFAULT_MONTANT_TTC = 1D;
    private static final Double UPDATED_MONTANT_TTC = 2D;

    private static final Integer DEFAULT_TYPE_INDEX = 1;
    private static final Integer UPDATED_TYPE_INDEX = 2;

    private static final Long DEFAULT_ANCIEN_INDEX = 1L;
    private static final Long UPDATED_ANCIEN_INDEX = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX = 1L;
    private static final Long UPDATED_NOUVEL_INDEX = 2L;

    private static final LocalDate DEFAULT_DATE_DEBUT_CONSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEBUT_CONSO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_FIN_CONSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FIN_CONSO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PERIODES = "AAAAAAAAAA";
    private static final String UPDATED_PERIODES = "BBBBBBBBBB";

    private static final String DEFAULT_PERIODE_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_PERIODE_REFERENCE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CATEGORIE_FACTURE = 1;
    private static final Integer UPDATED_CATEGORIE_FACTURE = 2;

    private static final String DEFAULT_PUISSANCE_APPELEE = "AAAAAAAAAA";
    private static final String UPDATED_PUISSANCE_APPELEE = "BBBBBBBBBB";

    private static final Float DEFAULT_COS_PHI = 1F;
    private static final Float UPDATED_COS_PHI = 2F;

    private static final String DEFAULT_RDPC = "AAAAAAAAAA";
    private static final String UPDATED_RDPC = "BBBBBBBBBB";

    private static final Long DEFAULT_ANCIEN_INDEX_EAN = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_EAN = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_EAN = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_EAN = 2L;

    private static final String DEFAULT_EA_NORMALE = "AAAAAAAAAA";
    private static final String UPDATED_EA_NORMALE = "BBBBBBBBBB";

    private static final Long DEFAULT_ANCIEN_INDEX_EAC = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_EAC = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_EAC = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_EAC = 2L;

    private static final Long DEFAULT_EA_CREUSE = 1L;
    private static final Long UPDATED_EA_CREUSE = 2L;

    private static final Long DEFAULT_ANCIEN_INDEX_EAP = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_EAP = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_EAP = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_EAP = 2L;

    private static final String DEFAULT_EA_POINTES = "AAAAAAAAAA";
    private static final String UPDATED_EA_POINTES = "BBBBBBBBBB";

    private static final Float DEFAULT_ENERGIE_REACTIVE = 1F;
    private static final Float UPDATED_ENERGIE_REACTIVE = 2F;

    private static final Long DEFAULT_HEURES_UTILISEES = 1L;
    private static final Long UPDATED_HEURES_UTILISEES = 2L;

    private static final Long DEFAULT_INDICE_MAXIMAL = 1L;
    private static final Long UPDATED_INDICE_MAXIMAL = 2L;

    private static final LocalDate DEFAULT_DATE_MODIFICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_MODIFICATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_SUPPRESSION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_SUPPRESSION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_RENDRE_FACTURE_AS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_RENDRE_FACTURE_AS = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STATUT_FACTURE = "AAAAAAAAAA";
    private static final String UPDATED_STATUT_FACTURE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_VALIDATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_VALIDATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_REJET = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_REJET = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_ID_USER_CREATION = 1L;
    private static final Long UPDATED_ID_USER_CREATION = 2L;

    private static final Long DEFAULT_ID_USER_VALIDATION = 1L;
    private static final Long UPDATED_ID_USER_VALIDATION = 2L;

    private static final Long DEFAULT_ID_USER_REJET = 1L;
    private static final Long UPDATED_ID_USER_REJET = 2L;

    private static final Long DEFAULT_ID_USER_MODIFICATION = 1L;
    private static final Long UPDATED_ID_USER_MODIFICATION = 2L;

    private static final Long DEFAULT_ID_USER_SUPPRESSION = 1L;
    private static final Long UPDATED_ID_USER_SUPPRESSION = 2L;

    private static final Long DEFAULT_ID_USER_RENDRE_FACTURE_AS = 1L;
    private static final Long UPDATED_ID_USER_RENDRE_FACTURE_AS = 2L;

    private static final String DEFAULT_OBSERVATION = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATION = "BBBBBBBBBB";

    private static final String DEFAULT_MOTIF_REJET = "AAAAAAAAAA";
    private static final String UPDATED_MOTIF_REJET = "BBBBBBBBBB";

    private static final String DEFAULT_REJET_MOTIF = "AAAAAAAAAA";
    private static final String UPDATED_REJET_MOTIF = "BBBBBBBBBB";

    private static final Long DEFAULT_ANCIEN_INDEX_EA = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_EA = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_EA = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_EA = 2L;

    private static final Long DEFAULT_ANCIEN_INDEX_ER = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_ER = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_ER = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_ER = 2L;

    private static final Long DEFAULT_ANCIEN_INDEX_HU = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_HU = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_HU = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_HU = 2L;

    private static final Long DEFAULT_ANCIEN_INDEX_IM = 1L;
    private static final Long UPDATED_ANCIEN_INDEX_IM = 2L;

    private static final Long DEFAULT_NOUVEL_INDEX_IM = 1L;
    private static final Long UPDATED_NOUVEL_INDEX_IM = 2L;

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

    private static final String ENTITY_API_URL = "/api/factures";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private FactureMapper factureMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFactureMockMvc;

    private Facture facture;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Facture createEntity(EntityManager em) {
        Facture facture = new Facture()
            .idIOC(DEFAULT_ID_IOC)
            .numeroFacture(DEFAULT_NUMERO_FACTURE)
            .dateFacture(DEFAULT_DATE_FACTURE)
            .codeMemoire(DEFAULT_CODE_MEMOIRE)
            .idMemoire(DEFAULT_ID_MEMOIRE)
            .montantTTC(DEFAULT_MONTANT_TTC)
            .typeIndex(DEFAULT_TYPE_INDEX)
            .ancienIndex(DEFAULT_ANCIEN_INDEX)
            .nouvelIndex(DEFAULT_NOUVEL_INDEX)
            .dateDebutConso(DEFAULT_DATE_DEBUT_CONSO)
            .dateFinConso(DEFAULT_DATE_FIN_CONSO)
            .periodes(DEFAULT_PERIODES)
            .periodeReference(DEFAULT_PERIODE_REFERENCE)
            .categorieFacture(DEFAULT_CATEGORIE_FACTURE)
            .puissanceAppelee(DEFAULT_PUISSANCE_APPELEE)
            .cosPhi(DEFAULT_COS_PHI)
            .rdpc(DEFAULT_RDPC)
            .ancienIndexEan(DEFAULT_ANCIEN_INDEX_EAN)
            .nouvelIndexEan(DEFAULT_NOUVEL_INDEX_EAN)
            .eaNormale(DEFAULT_EA_NORMALE)
            .ancienIndexEac(DEFAULT_ANCIEN_INDEX_EAC)
            .nouvelIndexEac(DEFAULT_NOUVEL_INDEX_EAC)
            .eaCreuse(DEFAULT_EA_CREUSE)
            .ancienIndexEap(DEFAULT_ANCIEN_INDEX_EAP)
            .nouvelIndexEap(DEFAULT_NOUVEL_INDEX_EAP)
            .eaPointes(DEFAULT_EA_POINTES)
            .energieReactive(DEFAULT_ENERGIE_REACTIVE)
            .heuresUtilisees(DEFAULT_HEURES_UTILISEES)
            .indiceMaximal(DEFAULT_INDICE_MAXIMAL)
            .dateModification(DEFAULT_DATE_MODIFICATION)
            .dateSuppression(DEFAULT_DATE_SUPPRESSION)
            .dateRendreFactureAs(DEFAULT_DATE_RENDRE_FACTURE_AS)
            .statutFacture(DEFAULT_STATUT_FACTURE)
            .dateCreation(DEFAULT_DATE_CREATION)
            .dateValidation(DEFAULT_DATE_VALIDATION)
            .dateRejet(DEFAULT_DATE_REJET)
            .idUserCreation(DEFAULT_ID_USER_CREATION)
            .idUserValidation(DEFAULT_ID_USER_VALIDATION)
            .idUserRejet(DEFAULT_ID_USER_REJET)
            .idUserModification(DEFAULT_ID_USER_MODIFICATION)
            .idUserSuppression(DEFAULT_ID_USER_SUPPRESSION)
            .idUserRendreFactureAs(DEFAULT_ID_USER_RENDRE_FACTURE_AS)
            .observation(DEFAULT_OBSERVATION)
            .motifRejet(DEFAULT_MOTIF_REJET)
            .rejetMotif(DEFAULT_REJET_MOTIF)
            .ancienIndexEa(DEFAULT_ANCIEN_INDEX_EA)
            .nouvelIndexEa(DEFAULT_NOUVEL_INDEX_EA)
            .ancienIndexEr(DEFAULT_ANCIEN_INDEX_ER)
            .nouvelIndexEr(DEFAULT_NOUVEL_INDEX_ER)
            .ancienIndexHu(DEFAULT_ANCIEN_INDEX_HU)
            .nouvelIndexHu(DEFAULT_NOUVEL_INDEX_HU)
            .ancienIndexIm(DEFAULT_ANCIEN_INDEX_IM)
            .nouvelIndexIm(DEFAULT_NOUVEL_INDEX_IM)
            .montantTVA7(DEFAULT_MONTANT_TVA_7)
            .montantHT7(DEFAULT_MONTANT_HT_7)
            .montantTVA14(DEFAULT_MONTANT_TVA_14)
            .montantHT14(DEFAULT_MONTANT_HT_14)
            .montantTVA20(DEFAULT_MONTANT_TVA_20)
            .montantHT20(DEFAULT_MONTANT_HT_20)
            .montantTvaManue(DEFAULT_MONTANT_TVA_MANUE)
            .diversesTaxes(DEFAULT_DIVERSES_TAXES);
        return facture;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Facture createUpdatedEntity(EntityManager em) {
        Facture facture = new Facture()
            .idIOC(UPDATED_ID_IOC)
            .numeroFacture(UPDATED_NUMERO_FACTURE)
            .dateFacture(UPDATED_DATE_FACTURE)
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .idMemoire(UPDATED_ID_MEMOIRE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .typeIndex(UPDATED_TYPE_INDEX)
            .ancienIndex(UPDATED_ANCIEN_INDEX)
            .nouvelIndex(UPDATED_NOUVEL_INDEX)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .periodes(UPDATED_PERIODES)
            .periodeReference(UPDATED_PERIODE_REFERENCE)
            .categorieFacture(UPDATED_CATEGORIE_FACTURE)
            .puissanceAppelee(UPDATED_PUISSANCE_APPELEE)
            .cosPhi(UPDATED_COS_PHI)
            .rdpc(UPDATED_RDPC)
            .ancienIndexEan(UPDATED_ANCIEN_INDEX_EAN)
            .nouvelIndexEan(UPDATED_NOUVEL_INDEX_EAN)
            .eaNormale(UPDATED_EA_NORMALE)
            .ancienIndexEac(UPDATED_ANCIEN_INDEX_EAC)
            .nouvelIndexEac(UPDATED_NOUVEL_INDEX_EAC)
            .eaCreuse(UPDATED_EA_CREUSE)
            .ancienIndexEap(UPDATED_ANCIEN_INDEX_EAP)
            .nouvelIndexEap(UPDATED_NOUVEL_INDEX_EAP)
            .eaPointes(UPDATED_EA_POINTES)
            .energieReactive(UPDATED_ENERGIE_REACTIVE)
            .heuresUtilisees(UPDATED_HEURES_UTILISEES)
            .indiceMaximal(UPDATED_INDICE_MAXIMAL)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .dateSuppression(UPDATED_DATE_SUPPRESSION)
            .dateRendreFactureAs(UPDATED_DATE_RENDRE_FACTURE_AS)
            .statutFacture(UPDATED_STATUT_FACTURE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserModification(UPDATED_ID_USER_MODIFICATION)
            .idUserSuppression(UPDATED_ID_USER_SUPPRESSION)
            .idUserRendreFactureAs(UPDATED_ID_USER_RENDRE_FACTURE_AS)
            .observation(UPDATED_OBSERVATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .rejetMotif(UPDATED_REJET_MOTIF)
            .ancienIndexEa(UPDATED_ANCIEN_INDEX_EA)
            .nouvelIndexEa(UPDATED_NOUVEL_INDEX_EA)
            .ancienIndexEr(UPDATED_ANCIEN_INDEX_ER)
            .nouvelIndexEr(UPDATED_NOUVEL_INDEX_ER)
            .ancienIndexHu(UPDATED_ANCIEN_INDEX_HU)
            .nouvelIndexHu(UPDATED_NOUVEL_INDEX_HU)
            .ancienIndexIm(UPDATED_ANCIEN_INDEX_IM)
            .nouvelIndexIm(UPDATED_NOUVEL_INDEX_IM)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES);
        return facture;
    }

    @BeforeEach
    public void initTest() {
        facture = createEntity(em);
    }

    @Test
    @Transactional
    void createFacture() throws Exception {
        int databaseSizeBeforeCreate = factureRepository.findAll().size();
        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);
        restFactureMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(factureDTO)))
            .andExpect(status().isCreated());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeCreate + 1);
        Facture testFacture = factureList.get(factureList.size() - 1);
        assertThat(testFacture.getIdIOC()).isEqualTo(DEFAULT_ID_IOC);
        assertThat(testFacture.getNumeroFacture()).isEqualTo(DEFAULT_NUMERO_FACTURE);
        assertThat(testFacture.getDateFacture()).isEqualTo(DEFAULT_DATE_FACTURE);
        assertThat(testFacture.getCodeMemoire()).isEqualTo(DEFAULT_CODE_MEMOIRE);
        assertThat(testFacture.getIdMemoire()).isEqualTo(DEFAULT_ID_MEMOIRE);
        assertThat(testFacture.getMontantTTC()).isEqualTo(DEFAULT_MONTANT_TTC);
        assertThat(testFacture.getTypeIndex()).isEqualTo(DEFAULT_TYPE_INDEX);
        assertThat(testFacture.getAncienIndex()).isEqualTo(DEFAULT_ANCIEN_INDEX);
        assertThat(testFacture.getNouvelIndex()).isEqualTo(DEFAULT_NOUVEL_INDEX);
        assertThat(testFacture.getDateDebutConso()).isEqualTo(DEFAULT_DATE_DEBUT_CONSO);
        assertThat(testFacture.getDateFinConso()).isEqualTo(DEFAULT_DATE_FIN_CONSO);
        assertThat(testFacture.getPeriodes()).isEqualTo(DEFAULT_PERIODES);
        assertThat(testFacture.getPeriodeReference()).isEqualTo(DEFAULT_PERIODE_REFERENCE);
        assertThat(testFacture.getCategorieFacture()).isEqualTo(DEFAULT_CATEGORIE_FACTURE);
        assertThat(testFacture.getPuissanceAppelee()).isEqualTo(DEFAULT_PUISSANCE_APPELEE);
        assertThat(testFacture.getCosPhi()).isEqualTo(DEFAULT_COS_PHI);
        assertThat(testFacture.getRdpc()).isEqualTo(DEFAULT_RDPC);
        assertThat(testFacture.getAncienIndexEan()).isEqualTo(DEFAULT_ANCIEN_INDEX_EAN);
        assertThat(testFacture.getNouvelIndexEan()).isEqualTo(DEFAULT_NOUVEL_INDEX_EAN);
        assertThat(testFacture.getEaNormale()).isEqualTo(DEFAULT_EA_NORMALE);
        assertThat(testFacture.getAncienIndexEac()).isEqualTo(DEFAULT_ANCIEN_INDEX_EAC);
        assertThat(testFacture.getNouvelIndexEac()).isEqualTo(DEFAULT_NOUVEL_INDEX_EAC);
        assertThat(testFacture.getEaCreuse()).isEqualTo(DEFAULT_EA_CREUSE);
        assertThat(testFacture.getAncienIndexEap()).isEqualTo(DEFAULT_ANCIEN_INDEX_EAP);
        assertThat(testFacture.getNouvelIndexEap()).isEqualTo(DEFAULT_NOUVEL_INDEX_EAP);
        assertThat(testFacture.getEaPointes()).isEqualTo(DEFAULT_EA_POINTES);
        assertThat(testFacture.getEnergieReactive()).isEqualTo(DEFAULT_ENERGIE_REACTIVE);
        assertThat(testFacture.getHeuresUtilisees()).isEqualTo(DEFAULT_HEURES_UTILISEES);
        assertThat(testFacture.getIndiceMaximal()).isEqualTo(DEFAULT_INDICE_MAXIMAL);
        assertThat(testFacture.getDateModification()).isEqualTo(DEFAULT_DATE_MODIFICATION);
        assertThat(testFacture.getDateSuppression()).isEqualTo(DEFAULT_DATE_SUPPRESSION);
        assertThat(testFacture.getDateRendreFactureAs()).isEqualTo(DEFAULT_DATE_RENDRE_FACTURE_AS);
        assertThat(testFacture.getStatutFacture()).isEqualTo(DEFAULT_STATUT_FACTURE);
        assertThat(testFacture.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testFacture.getDateValidation()).isEqualTo(DEFAULT_DATE_VALIDATION);
        assertThat(testFacture.getDateRejet()).isEqualTo(DEFAULT_DATE_REJET);
        assertThat(testFacture.getIdUserCreation()).isEqualTo(DEFAULT_ID_USER_CREATION);
        assertThat(testFacture.getIdUserValidation()).isEqualTo(DEFAULT_ID_USER_VALIDATION);
        assertThat(testFacture.getIdUserRejet()).isEqualTo(DEFAULT_ID_USER_REJET);
        assertThat(testFacture.getIdUserModification()).isEqualTo(DEFAULT_ID_USER_MODIFICATION);
        assertThat(testFacture.getIdUserSuppression()).isEqualTo(DEFAULT_ID_USER_SUPPRESSION);
        assertThat(testFacture.getIdUserRendreFactureAs()).isEqualTo(DEFAULT_ID_USER_RENDRE_FACTURE_AS);
        assertThat(testFacture.getObservation()).isEqualTo(DEFAULT_OBSERVATION);
        assertThat(testFacture.getMotifRejet()).isEqualTo(DEFAULT_MOTIF_REJET);
        assertThat(testFacture.getRejetMotif()).isEqualTo(DEFAULT_REJET_MOTIF);
        assertThat(testFacture.getAncienIndexEa()).isEqualTo(DEFAULT_ANCIEN_INDEX_EA);
        assertThat(testFacture.getNouvelIndexEa()).isEqualTo(DEFAULT_NOUVEL_INDEX_EA);
        assertThat(testFacture.getAncienIndexEr()).isEqualTo(DEFAULT_ANCIEN_INDEX_ER);
        assertThat(testFacture.getNouvelIndexEr()).isEqualTo(DEFAULT_NOUVEL_INDEX_ER);
        assertThat(testFacture.getAncienIndexHu()).isEqualTo(DEFAULT_ANCIEN_INDEX_HU);
        assertThat(testFacture.getNouvelIndexHu()).isEqualTo(DEFAULT_NOUVEL_INDEX_HU);
        assertThat(testFacture.getAncienIndexIm()).isEqualTo(DEFAULT_ANCIEN_INDEX_IM);
        assertThat(testFacture.getNouvelIndexIm()).isEqualTo(DEFAULT_NOUVEL_INDEX_IM);
        assertThat(testFacture.getMontantTVA7()).isEqualTo(DEFAULT_MONTANT_TVA_7);
        assertThat(testFacture.getMontantHT7()).isEqualTo(DEFAULT_MONTANT_HT_7);
        assertThat(testFacture.getMontantTVA14()).isEqualTo(DEFAULT_MONTANT_TVA_14);
        assertThat(testFacture.getMontantHT14()).isEqualTo(DEFAULT_MONTANT_HT_14);
        assertThat(testFacture.getMontantTVA20()).isEqualTo(DEFAULT_MONTANT_TVA_20);
        assertThat(testFacture.getMontantHT20()).isEqualTo(DEFAULT_MONTANT_HT_20);
        assertThat(testFacture.getMontantTvaManue()).isEqualTo(DEFAULT_MONTANT_TVA_MANUE);
        assertThat(testFacture.getDiversesTaxes()).isEqualTo(DEFAULT_DIVERSES_TAXES);
    }

    @Test
    @Transactional
    void createFactureWithExistingId() throws Exception {
        // Create the Facture with an existing ID
        facture.setId(1L);
        FactureDTO factureDTO = factureMapper.toDto(facture);

        int databaseSizeBeforeCreate = factureRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFactureMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(factureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllFactures() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        // Get all the factureList
        restFactureMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(facture.getId().intValue())))
            .andExpect(jsonPath("$.[*].idIOC").value(hasItem(DEFAULT_ID_IOC.intValue())))
            .andExpect(jsonPath("$.[*].numeroFacture").value(hasItem(DEFAULT_NUMERO_FACTURE.intValue())))
            .andExpect(jsonPath("$.[*].dateFacture").value(hasItem(DEFAULT_DATE_FACTURE.toString())))
            .andExpect(jsonPath("$.[*].codeMemoire").value(hasItem(DEFAULT_CODE_MEMOIRE)))
            .andExpect(jsonPath("$.[*].idMemoire").value(hasItem(DEFAULT_ID_MEMOIRE.intValue())))
            .andExpect(jsonPath("$.[*].montantTTC").value(hasItem(DEFAULT_MONTANT_TTC.doubleValue())))
            .andExpect(jsonPath("$.[*].typeIndex").value(hasItem(DEFAULT_TYPE_INDEX)))
            .andExpect(jsonPath("$.[*].ancienIndex").value(hasItem(DEFAULT_ANCIEN_INDEX.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndex").value(hasItem(DEFAULT_NOUVEL_INDEX.intValue())))
            .andExpect(jsonPath("$.[*].dateDebutConso").value(hasItem(DEFAULT_DATE_DEBUT_CONSO.toString())))
            .andExpect(jsonPath("$.[*].dateFinConso").value(hasItem(DEFAULT_DATE_FIN_CONSO.toString())))
            .andExpect(jsonPath("$.[*].periodes").value(hasItem(DEFAULT_PERIODES)))
            .andExpect(jsonPath("$.[*].periodeReference").value(hasItem(DEFAULT_PERIODE_REFERENCE)))
            .andExpect(jsonPath("$.[*].categorieFacture").value(hasItem(DEFAULT_CATEGORIE_FACTURE)))
            .andExpect(jsonPath("$.[*].puissanceAppelee").value(hasItem(DEFAULT_PUISSANCE_APPELEE)))
            .andExpect(jsonPath("$.[*].cosPhi").value(hasItem(DEFAULT_COS_PHI.doubleValue())))
            .andExpect(jsonPath("$.[*].rdpc").value(hasItem(DEFAULT_RDPC)))
            .andExpect(jsonPath("$.[*].ancienIndexEan").value(hasItem(DEFAULT_ANCIEN_INDEX_EAN.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexEan").value(hasItem(DEFAULT_NOUVEL_INDEX_EAN.intValue())))
            .andExpect(jsonPath("$.[*].eaNormale").value(hasItem(DEFAULT_EA_NORMALE)))
            .andExpect(jsonPath("$.[*].ancienIndexEac").value(hasItem(DEFAULT_ANCIEN_INDEX_EAC.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexEac").value(hasItem(DEFAULT_NOUVEL_INDEX_EAC.intValue())))
            .andExpect(jsonPath("$.[*].eaCreuse").value(hasItem(DEFAULT_EA_CREUSE.intValue())))
            .andExpect(jsonPath("$.[*].ancienIndexEap").value(hasItem(DEFAULT_ANCIEN_INDEX_EAP.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexEap").value(hasItem(DEFAULT_NOUVEL_INDEX_EAP.intValue())))
            .andExpect(jsonPath("$.[*].eaPointes").value(hasItem(DEFAULT_EA_POINTES)))
            .andExpect(jsonPath("$.[*].energieReactive").value(hasItem(DEFAULT_ENERGIE_REACTIVE.doubleValue())))
            .andExpect(jsonPath("$.[*].heuresUtilisees").value(hasItem(DEFAULT_HEURES_UTILISEES.intValue())))
            .andExpect(jsonPath("$.[*].indiceMaximal").value(hasItem(DEFAULT_INDICE_MAXIMAL.intValue())))
            .andExpect(jsonPath("$.[*].dateModification").value(hasItem(DEFAULT_DATE_MODIFICATION.toString())))
            .andExpect(jsonPath("$.[*].dateSuppression").value(hasItem(DEFAULT_DATE_SUPPRESSION.toString())))
            .andExpect(jsonPath("$.[*].dateRendreFactureAs").value(hasItem(DEFAULT_DATE_RENDRE_FACTURE_AS.toString())))
            .andExpect(jsonPath("$.[*].statutFacture").value(hasItem(DEFAULT_STATUT_FACTURE)))
            .andExpect(jsonPath("$.[*].dateCreation").value(hasItem(DEFAULT_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].dateValidation").value(hasItem(DEFAULT_DATE_VALIDATION.toString())))
            .andExpect(jsonPath("$.[*].dateRejet").value(hasItem(DEFAULT_DATE_REJET.toString())))
            .andExpect(jsonPath("$.[*].idUserCreation").value(hasItem(DEFAULT_ID_USER_CREATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserValidation").value(hasItem(DEFAULT_ID_USER_VALIDATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserRejet").value(hasItem(DEFAULT_ID_USER_REJET.intValue())))
            .andExpect(jsonPath("$.[*].idUserModification").value(hasItem(DEFAULT_ID_USER_MODIFICATION.intValue())))
            .andExpect(jsonPath("$.[*].idUserSuppression").value(hasItem(DEFAULT_ID_USER_SUPPRESSION.intValue())))
            .andExpect(jsonPath("$.[*].idUserRendreFactureAs").value(hasItem(DEFAULT_ID_USER_RENDRE_FACTURE_AS.intValue())))
            .andExpect(jsonPath("$.[*].observation").value(hasItem(DEFAULT_OBSERVATION)))
            .andExpect(jsonPath("$.[*].motifRejet").value(hasItem(DEFAULT_MOTIF_REJET)))
            .andExpect(jsonPath("$.[*].rejetMotif").value(hasItem(DEFAULT_REJET_MOTIF)))
            .andExpect(jsonPath("$.[*].ancienIndexEa").value(hasItem(DEFAULT_ANCIEN_INDEX_EA.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexEa").value(hasItem(DEFAULT_NOUVEL_INDEX_EA.intValue())))
            .andExpect(jsonPath("$.[*].ancienIndexEr").value(hasItem(DEFAULT_ANCIEN_INDEX_ER.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexEr").value(hasItem(DEFAULT_NOUVEL_INDEX_ER.intValue())))
            .andExpect(jsonPath("$.[*].ancienIndexHu").value(hasItem(DEFAULT_ANCIEN_INDEX_HU.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexHu").value(hasItem(DEFAULT_NOUVEL_INDEX_HU.intValue())))
            .andExpect(jsonPath("$.[*].ancienIndexIm").value(hasItem(DEFAULT_ANCIEN_INDEX_IM.intValue())))
            .andExpect(jsonPath("$.[*].nouvelIndexIm").value(hasItem(DEFAULT_NOUVEL_INDEX_IM.intValue())))
            .andExpect(jsonPath("$.[*].montantTVA7").value(hasItem(DEFAULT_MONTANT_TVA_7.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT7").value(hasItem(DEFAULT_MONTANT_HT_7.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTVA14").value(hasItem(DEFAULT_MONTANT_TVA_14.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT14").value(hasItem(DEFAULT_MONTANT_HT_14.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTVA20").value(hasItem(DEFAULT_MONTANT_TVA_20.doubleValue())))
            .andExpect(jsonPath("$.[*].montantHT20").value(hasItem(DEFAULT_MONTANT_HT_20.doubleValue())))
            .andExpect(jsonPath("$.[*].montantTvaManue").value(hasItem(DEFAULT_MONTANT_TVA_MANUE.doubleValue())))
            .andExpect(jsonPath("$.[*].diversesTaxes").value(hasItem(DEFAULT_DIVERSES_TAXES.doubleValue())));
    }

    @Test
    @Transactional
    void getFacture() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        // Get the facture
        restFactureMockMvc
            .perform(get(ENTITY_API_URL_ID, facture.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(facture.getId().intValue()))
            .andExpect(jsonPath("$.idIOC").value(DEFAULT_ID_IOC.intValue()))
            .andExpect(jsonPath("$.numeroFacture").value(DEFAULT_NUMERO_FACTURE.intValue()))
            .andExpect(jsonPath("$.dateFacture").value(DEFAULT_DATE_FACTURE.toString()))
            .andExpect(jsonPath("$.codeMemoire").value(DEFAULT_CODE_MEMOIRE))
            .andExpect(jsonPath("$.idMemoire").value(DEFAULT_ID_MEMOIRE.intValue()))
            .andExpect(jsonPath("$.montantTTC").value(DEFAULT_MONTANT_TTC.doubleValue()))
            .andExpect(jsonPath("$.typeIndex").value(DEFAULT_TYPE_INDEX))
            .andExpect(jsonPath("$.ancienIndex").value(DEFAULT_ANCIEN_INDEX.intValue()))
            .andExpect(jsonPath("$.nouvelIndex").value(DEFAULT_NOUVEL_INDEX.intValue()))
            .andExpect(jsonPath("$.dateDebutConso").value(DEFAULT_DATE_DEBUT_CONSO.toString()))
            .andExpect(jsonPath("$.dateFinConso").value(DEFAULT_DATE_FIN_CONSO.toString()))
            .andExpect(jsonPath("$.periodes").value(DEFAULT_PERIODES))
            .andExpect(jsonPath("$.periodeReference").value(DEFAULT_PERIODE_REFERENCE))
            .andExpect(jsonPath("$.categorieFacture").value(DEFAULT_CATEGORIE_FACTURE))
            .andExpect(jsonPath("$.puissanceAppelee").value(DEFAULT_PUISSANCE_APPELEE))
            .andExpect(jsonPath("$.cosPhi").value(DEFAULT_COS_PHI.doubleValue()))
            .andExpect(jsonPath("$.rdpc").value(DEFAULT_RDPC))
            .andExpect(jsonPath("$.ancienIndexEan").value(DEFAULT_ANCIEN_INDEX_EAN.intValue()))
            .andExpect(jsonPath("$.nouvelIndexEan").value(DEFAULT_NOUVEL_INDEX_EAN.intValue()))
            .andExpect(jsonPath("$.eaNormale").value(DEFAULT_EA_NORMALE))
            .andExpect(jsonPath("$.ancienIndexEac").value(DEFAULT_ANCIEN_INDEX_EAC.intValue()))
            .andExpect(jsonPath("$.nouvelIndexEac").value(DEFAULT_NOUVEL_INDEX_EAC.intValue()))
            .andExpect(jsonPath("$.eaCreuse").value(DEFAULT_EA_CREUSE.intValue()))
            .andExpect(jsonPath("$.ancienIndexEap").value(DEFAULT_ANCIEN_INDEX_EAP.intValue()))
            .andExpect(jsonPath("$.nouvelIndexEap").value(DEFAULT_NOUVEL_INDEX_EAP.intValue()))
            .andExpect(jsonPath("$.eaPointes").value(DEFAULT_EA_POINTES))
            .andExpect(jsonPath("$.energieReactive").value(DEFAULT_ENERGIE_REACTIVE.doubleValue()))
            .andExpect(jsonPath("$.heuresUtilisees").value(DEFAULT_HEURES_UTILISEES.intValue()))
            .andExpect(jsonPath("$.indiceMaximal").value(DEFAULT_INDICE_MAXIMAL.intValue()))
            .andExpect(jsonPath("$.dateModification").value(DEFAULT_DATE_MODIFICATION.toString()))
            .andExpect(jsonPath("$.dateSuppression").value(DEFAULT_DATE_SUPPRESSION.toString()))
            .andExpect(jsonPath("$.dateRendreFactureAs").value(DEFAULT_DATE_RENDRE_FACTURE_AS.toString()))
            .andExpect(jsonPath("$.statutFacture").value(DEFAULT_STATUT_FACTURE))
            .andExpect(jsonPath("$.dateCreation").value(DEFAULT_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.dateValidation").value(DEFAULT_DATE_VALIDATION.toString()))
            .andExpect(jsonPath("$.dateRejet").value(DEFAULT_DATE_REJET.toString()))
            .andExpect(jsonPath("$.idUserCreation").value(DEFAULT_ID_USER_CREATION.intValue()))
            .andExpect(jsonPath("$.idUserValidation").value(DEFAULT_ID_USER_VALIDATION.intValue()))
            .andExpect(jsonPath("$.idUserRejet").value(DEFAULT_ID_USER_REJET.intValue()))
            .andExpect(jsonPath("$.idUserModification").value(DEFAULT_ID_USER_MODIFICATION.intValue()))
            .andExpect(jsonPath("$.idUserSuppression").value(DEFAULT_ID_USER_SUPPRESSION.intValue()))
            .andExpect(jsonPath("$.idUserRendreFactureAs").value(DEFAULT_ID_USER_RENDRE_FACTURE_AS.intValue()))
            .andExpect(jsonPath("$.observation").value(DEFAULT_OBSERVATION))
            .andExpect(jsonPath("$.motifRejet").value(DEFAULT_MOTIF_REJET))
            .andExpect(jsonPath("$.rejetMotif").value(DEFAULT_REJET_MOTIF))
            .andExpect(jsonPath("$.ancienIndexEa").value(DEFAULT_ANCIEN_INDEX_EA.intValue()))
            .andExpect(jsonPath("$.nouvelIndexEa").value(DEFAULT_NOUVEL_INDEX_EA.intValue()))
            .andExpect(jsonPath("$.ancienIndexEr").value(DEFAULT_ANCIEN_INDEX_ER.intValue()))
            .andExpect(jsonPath("$.nouvelIndexEr").value(DEFAULT_NOUVEL_INDEX_ER.intValue()))
            .andExpect(jsonPath("$.ancienIndexHu").value(DEFAULT_ANCIEN_INDEX_HU.intValue()))
            .andExpect(jsonPath("$.nouvelIndexHu").value(DEFAULT_NOUVEL_INDEX_HU.intValue()))
            .andExpect(jsonPath("$.ancienIndexIm").value(DEFAULT_ANCIEN_INDEX_IM.intValue()))
            .andExpect(jsonPath("$.nouvelIndexIm").value(DEFAULT_NOUVEL_INDEX_IM.intValue()))
            .andExpect(jsonPath("$.montantTVA7").value(DEFAULT_MONTANT_TVA_7.doubleValue()))
            .andExpect(jsonPath("$.montantHT7").value(DEFAULT_MONTANT_HT_7.doubleValue()))
            .andExpect(jsonPath("$.montantTVA14").value(DEFAULT_MONTANT_TVA_14.doubleValue()))
            .andExpect(jsonPath("$.montantHT14").value(DEFAULT_MONTANT_HT_14.doubleValue()))
            .andExpect(jsonPath("$.montantTVA20").value(DEFAULT_MONTANT_TVA_20.doubleValue()))
            .andExpect(jsonPath("$.montantHT20").value(DEFAULT_MONTANT_HT_20.doubleValue()))
            .andExpect(jsonPath("$.montantTvaManue").value(DEFAULT_MONTANT_TVA_MANUE.doubleValue()))
            .andExpect(jsonPath("$.diversesTaxes").value(DEFAULT_DIVERSES_TAXES.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingFacture() throws Exception {
        // Get the facture
        restFactureMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewFacture() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        int databaseSizeBeforeUpdate = factureRepository.findAll().size();

        // Update the facture
        Facture updatedFacture = factureRepository.findById(facture.getId()).get();
        // Disconnect from session so that the updates on updatedFacture are not directly saved in db
        em.detach(updatedFacture);
        updatedFacture
            .idIOC(UPDATED_ID_IOC)
            .numeroFacture(UPDATED_NUMERO_FACTURE)
            .dateFacture(UPDATED_DATE_FACTURE)
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .idMemoire(UPDATED_ID_MEMOIRE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .typeIndex(UPDATED_TYPE_INDEX)
            .ancienIndex(UPDATED_ANCIEN_INDEX)
            .nouvelIndex(UPDATED_NOUVEL_INDEX)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .periodes(UPDATED_PERIODES)
            .periodeReference(UPDATED_PERIODE_REFERENCE)
            .categorieFacture(UPDATED_CATEGORIE_FACTURE)
            .puissanceAppelee(UPDATED_PUISSANCE_APPELEE)
            .cosPhi(UPDATED_COS_PHI)
            .rdpc(UPDATED_RDPC)
            .ancienIndexEan(UPDATED_ANCIEN_INDEX_EAN)
            .nouvelIndexEan(UPDATED_NOUVEL_INDEX_EAN)
            .eaNormale(UPDATED_EA_NORMALE)
            .ancienIndexEac(UPDATED_ANCIEN_INDEX_EAC)
            .nouvelIndexEac(UPDATED_NOUVEL_INDEX_EAC)
            .eaCreuse(UPDATED_EA_CREUSE)
            .ancienIndexEap(UPDATED_ANCIEN_INDEX_EAP)
            .nouvelIndexEap(UPDATED_NOUVEL_INDEX_EAP)
            .eaPointes(UPDATED_EA_POINTES)
            .energieReactive(UPDATED_ENERGIE_REACTIVE)
            .heuresUtilisees(UPDATED_HEURES_UTILISEES)
            .indiceMaximal(UPDATED_INDICE_MAXIMAL)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .dateSuppression(UPDATED_DATE_SUPPRESSION)
            .dateRendreFactureAs(UPDATED_DATE_RENDRE_FACTURE_AS)
            .statutFacture(UPDATED_STATUT_FACTURE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserModification(UPDATED_ID_USER_MODIFICATION)
            .idUserSuppression(UPDATED_ID_USER_SUPPRESSION)
            .idUserRendreFactureAs(UPDATED_ID_USER_RENDRE_FACTURE_AS)
            .observation(UPDATED_OBSERVATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .rejetMotif(UPDATED_REJET_MOTIF)
            .ancienIndexEa(UPDATED_ANCIEN_INDEX_EA)
            .nouvelIndexEa(UPDATED_NOUVEL_INDEX_EA)
            .ancienIndexEr(UPDATED_ANCIEN_INDEX_ER)
            .nouvelIndexEr(UPDATED_NOUVEL_INDEX_ER)
            .ancienIndexHu(UPDATED_ANCIEN_INDEX_HU)
            .nouvelIndexHu(UPDATED_NOUVEL_INDEX_HU)
            .ancienIndexIm(UPDATED_ANCIEN_INDEX_IM)
            .nouvelIndexIm(UPDATED_NOUVEL_INDEX_IM)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES);
        FactureDTO factureDTO = factureMapper.toDto(updatedFacture);

        restFactureMockMvc
            .perform(
                put(ENTITY_API_URL_ID, factureDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isOk());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
        Facture testFacture = factureList.get(factureList.size() - 1);
        assertThat(testFacture.getIdIOC()).isEqualTo(UPDATED_ID_IOC);
        assertThat(testFacture.getNumeroFacture()).isEqualTo(UPDATED_NUMERO_FACTURE);
        assertThat(testFacture.getDateFacture()).isEqualTo(UPDATED_DATE_FACTURE);
        assertThat(testFacture.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testFacture.getIdMemoire()).isEqualTo(UPDATED_ID_MEMOIRE);
        assertThat(testFacture.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testFacture.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testFacture.getAncienIndex()).isEqualTo(UPDATED_ANCIEN_INDEX);
        assertThat(testFacture.getNouvelIndex()).isEqualTo(UPDATED_NOUVEL_INDEX);
        assertThat(testFacture.getDateDebutConso()).isEqualTo(UPDATED_DATE_DEBUT_CONSO);
        assertThat(testFacture.getDateFinConso()).isEqualTo(UPDATED_DATE_FIN_CONSO);
        assertThat(testFacture.getPeriodes()).isEqualTo(UPDATED_PERIODES);
        assertThat(testFacture.getPeriodeReference()).isEqualTo(UPDATED_PERIODE_REFERENCE);
        assertThat(testFacture.getCategorieFacture()).isEqualTo(UPDATED_CATEGORIE_FACTURE);
        assertThat(testFacture.getPuissanceAppelee()).isEqualTo(UPDATED_PUISSANCE_APPELEE);
        assertThat(testFacture.getCosPhi()).isEqualTo(UPDATED_COS_PHI);
        assertThat(testFacture.getRdpc()).isEqualTo(UPDATED_RDPC);
        assertThat(testFacture.getAncienIndexEan()).isEqualTo(UPDATED_ANCIEN_INDEX_EAN);
        assertThat(testFacture.getNouvelIndexEan()).isEqualTo(UPDATED_NOUVEL_INDEX_EAN);
        assertThat(testFacture.getEaNormale()).isEqualTo(UPDATED_EA_NORMALE);
        assertThat(testFacture.getAncienIndexEac()).isEqualTo(UPDATED_ANCIEN_INDEX_EAC);
        assertThat(testFacture.getNouvelIndexEac()).isEqualTo(UPDATED_NOUVEL_INDEX_EAC);
        assertThat(testFacture.getEaCreuse()).isEqualTo(UPDATED_EA_CREUSE);
        assertThat(testFacture.getAncienIndexEap()).isEqualTo(UPDATED_ANCIEN_INDEX_EAP);
        assertThat(testFacture.getNouvelIndexEap()).isEqualTo(UPDATED_NOUVEL_INDEX_EAP);
        assertThat(testFacture.getEaPointes()).isEqualTo(UPDATED_EA_POINTES);
        assertThat(testFacture.getEnergieReactive()).isEqualTo(UPDATED_ENERGIE_REACTIVE);
        assertThat(testFacture.getHeuresUtilisees()).isEqualTo(UPDATED_HEURES_UTILISEES);
        assertThat(testFacture.getIndiceMaximal()).isEqualTo(UPDATED_INDICE_MAXIMAL);
        assertThat(testFacture.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testFacture.getDateSuppression()).isEqualTo(UPDATED_DATE_SUPPRESSION);
        assertThat(testFacture.getDateRendreFactureAs()).isEqualTo(UPDATED_DATE_RENDRE_FACTURE_AS);
        assertThat(testFacture.getStatutFacture()).isEqualTo(UPDATED_STATUT_FACTURE);
        assertThat(testFacture.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testFacture.getDateValidation()).isEqualTo(UPDATED_DATE_VALIDATION);
        assertThat(testFacture.getDateRejet()).isEqualTo(UPDATED_DATE_REJET);
        assertThat(testFacture.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testFacture.getIdUserValidation()).isEqualTo(UPDATED_ID_USER_VALIDATION);
        assertThat(testFacture.getIdUserRejet()).isEqualTo(UPDATED_ID_USER_REJET);
        assertThat(testFacture.getIdUserModification()).isEqualTo(UPDATED_ID_USER_MODIFICATION);
        assertThat(testFacture.getIdUserSuppression()).isEqualTo(UPDATED_ID_USER_SUPPRESSION);
        assertThat(testFacture.getIdUserRendreFactureAs()).isEqualTo(UPDATED_ID_USER_RENDRE_FACTURE_AS);
        assertThat(testFacture.getObservation()).isEqualTo(UPDATED_OBSERVATION);
        assertThat(testFacture.getMotifRejet()).isEqualTo(UPDATED_MOTIF_REJET);
        assertThat(testFacture.getRejetMotif()).isEqualTo(UPDATED_REJET_MOTIF);
        assertThat(testFacture.getAncienIndexEa()).isEqualTo(UPDATED_ANCIEN_INDEX_EA);
        assertThat(testFacture.getNouvelIndexEa()).isEqualTo(UPDATED_NOUVEL_INDEX_EA);
        assertThat(testFacture.getAncienIndexEr()).isEqualTo(UPDATED_ANCIEN_INDEX_ER);
        assertThat(testFacture.getNouvelIndexEr()).isEqualTo(UPDATED_NOUVEL_INDEX_ER);
        assertThat(testFacture.getAncienIndexHu()).isEqualTo(UPDATED_ANCIEN_INDEX_HU);
        assertThat(testFacture.getNouvelIndexHu()).isEqualTo(UPDATED_NOUVEL_INDEX_HU);
        assertThat(testFacture.getAncienIndexIm()).isEqualTo(UPDATED_ANCIEN_INDEX_IM);
        assertThat(testFacture.getNouvelIndexIm()).isEqualTo(UPDATED_NOUVEL_INDEX_IM);
        assertThat(testFacture.getMontantTVA7()).isEqualTo(UPDATED_MONTANT_TVA_7);
        assertThat(testFacture.getMontantHT7()).isEqualTo(UPDATED_MONTANT_HT_7);
        assertThat(testFacture.getMontantTVA14()).isEqualTo(UPDATED_MONTANT_TVA_14);
        assertThat(testFacture.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testFacture.getMontantTVA20()).isEqualTo(UPDATED_MONTANT_TVA_20);
        assertThat(testFacture.getMontantHT20()).isEqualTo(UPDATED_MONTANT_HT_20);
        assertThat(testFacture.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testFacture.getDiversesTaxes()).isEqualTo(UPDATED_DIVERSES_TAXES);
    }

    @Test
    @Transactional
    void putNonExistingFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(
                put(ENTITY_API_URL_ID, factureDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(factureDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFactureWithPatch() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        int databaseSizeBeforeUpdate = factureRepository.findAll().size();

        // Update the facture using partial update
        Facture partialUpdatedFacture = new Facture();
        partialUpdatedFacture.setId(facture.getId());

        partialUpdatedFacture
            .numeroFacture(UPDATED_NUMERO_FACTURE)
            .dateFacture(UPDATED_DATE_FACTURE)
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .typeIndex(UPDATED_TYPE_INDEX)
            .ancienIndex(UPDATED_ANCIEN_INDEX)
            .puissanceAppelee(UPDATED_PUISSANCE_APPELEE)
            .cosPhi(UPDATED_COS_PHI)
            .ancienIndexEan(UPDATED_ANCIEN_INDEX_EAN)
            .nouvelIndexEan(UPDATED_NOUVEL_INDEX_EAN)
            .eaCreuse(UPDATED_EA_CREUSE)
            .ancienIndexEap(UPDATED_ANCIEN_INDEX_EAP)
            .nouvelIndexEap(UPDATED_NOUVEL_INDEX_EAP)
            .heuresUtilisees(UPDATED_HEURES_UTILISEES)
            .indiceMaximal(UPDATED_INDICE_MAXIMAL)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .dateSuppression(UPDATED_DATE_SUPPRESSION)
            .dateRejet(UPDATED_DATE_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserModification(UPDATED_ID_USER_MODIFICATION)
            .idUserSuppression(UPDATED_ID_USER_SUPPRESSION)
            .observation(UPDATED_OBSERVATION)
            .ancienIndexEa(UPDATED_ANCIEN_INDEX_EA)
            .nouvelIndexEa(UPDATED_NOUVEL_INDEX_EA)
            .nouvelIndexEr(UPDATED_NOUVEL_INDEX_ER)
            .ancienIndexHu(UPDATED_ANCIEN_INDEX_HU)
            .nouvelIndexHu(UPDATED_NOUVEL_INDEX_HU)
            .nouvelIndexIm(UPDATED_NOUVEL_INDEX_IM)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES);

        restFactureMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFacture.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFacture))
            )
            .andExpect(status().isOk());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
        Facture testFacture = factureList.get(factureList.size() - 1);
        assertThat(testFacture.getIdIOC()).isEqualTo(DEFAULT_ID_IOC);
        assertThat(testFacture.getNumeroFacture()).isEqualTo(UPDATED_NUMERO_FACTURE);
        assertThat(testFacture.getDateFacture()).isEqualTo(UPDATED_DATE_FACTURE);
        assertThat(testFacture.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testFacture.getIdMemoire()).isEqualTo(DEFAULT_ID_MEMOIRE);
        assertThat(testFacture.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testFacture.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testFacture.getAncienIndex()).isEqualTo(UPDATED_ANCIEN_INDEX);
        assertThat(testFacture.getNouvelIndex()).isEqualTo(DEFAULT_NOUVEL_INDEX);
        assertThat(testFacture.getDateDebutConso()).isEqualTo(DEFAULT_DATE_DEBUT_CONSO);
        assertThat(testFacture.getDateFinConso()).isEqualTo(DEFAULT_DATE_FIN_CONSO);
        assertThat(testFacture.getPeriodes()).isEqualTo(DEFAULT_PERIODES);
        assertThat(testFacture.getPeriodeReference()).isEqualTo(DEFAULT_PERIODE_REFERENCE);
        assertThat(testFacture.getCategorieFacture()).isEqualTo(DEFAULT_CATEGORIE_FACTURE);
        assertThat(testFacture.getPuissanceAppelee()).isEqualTo(UPDATED_PUISSANCE_APPELEE);
        assertThat(testFacture.getCosPhi()).isEqualTo(UPDATED_COS_PHI);
        assertThat(testFacture.getRdpc()).isEqualTo(DEFAULT_RDPC);
        assertThat(testFacture.getAncienIndexEan()).isEqualTo(UPDATED_ANCIEN_INDEX_EAN);
        assertThat(testFacture.getNouvelIndexEan()).isEqualTo(UPDATED_NOUVEL_INDEX_EAN);
        assertThat(testFacture.getEaNormale()).isEqualTo(DEFAULT_EA_NORMALE);
        assertThat(testFacture.getAncienIndexEac()).isEqualTo(DEFAULT_ANCIEN_INDEX_EAC);
        assertThat(testFacture.getNouvelIndexEac()).isEqualTo(DEFAULT_NOUVEL_INDEX_EAC);
        assertThat(testFacture.getEaCreuse()).isEqualTo(UPDATED_EA_CREUSE);
        assertThat(testFacture.getAncienIndexEap()).isEqualTo(UPDATED_ANCIEN_INDEX_EAP);
        assertThat(testFacture.getNouvelIndexEap()).isEqualTo(UPDATED_NOUVEL_INDEX_EAP);
        assertThat(testFacture.getEaPointes()).isEqualTo(DEFAULT_EA_POINTES);
        assertThat(testFacture.getEnergieReactive()).isEqualTo(DEFAULT_ENERGIE_REACTIVE);
        assertThat(testFacture.getHeuresUtilisees()).isEqualTo(UPDATED_HEURES_UTILISEES);
        assertThat(testFacture.getIndiceMaximal()).isEqualTo(UPDATED_INDICE_MAXIMAL);
        assertThat(testFacture.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testFacture.getDateSuppression()).isEqualTo(UPDATED_DATE_SUPPRESSION);
        assertThat(testFacture.getDateRendreFactureAs()).isEqualTo(DEFAULT_DATE_RENDRE_FACTURE_AS);
        assertThat(testFacture.getStatutFacture()).isEqualTo(DEFAULT_STATUT_FACTURE);
        assertThat(testFacture.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testFacture.getDateValidation()).isEqualTo(DEFAULT_DATE_VALIDATION);
        assertThat(testFacture.getDateRejet()).isEqualTo(UPDATED_DATE_REJET);
        assertThat(testFacture.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testFacture.getIdUserValidation()).isEqualTo(DEFAULT_ID_USER_VALIDATION);
        assertThat(testFacture.getIdUserRejet()).isEqualTo(DEFAULT_ID_USER_REJET);
        assertThat(testFacture.getIdUserModification()).isEqualTo(UPDATED_ID_USER_MODIFICATION);
        assertThat(testFacture.getIdUserSuppression()).isEqualTo(UPDATED_ID_USER_SUPPRESSION);
        assertThat(testFacture.getIdUserRendreFactureAs()).isEqualTo(DEFAULT_ID_USER_RENDRE_FACTURE_AS);
        assertThat(testFacture.getObservation()).isEqualTo(UPDATED_OBSERVATION);
        assertThat(testFacture.getMotifRejet()).isEqualTo(DEFAULT_MOTIF_REJET);
        assertThat(testFacture.getRejetMotif()).isEqualTo(DEFAULT_REJET_MOTIF);
        assertThat(testFacture.getAncienIndexEa()).isEqualTo(UPDATED_ANCIEN_INDEX_EA);
        assertThat(testFacture.getNouvelIndexEa()).isEqualTo(UPDATED_NOUVEL_INDEX_EA);
        assertThat(testFacture.getAncienIndexEr()).isEqualTo(DEFAULT_ANCIEN_INDEX_ER);
        assertThat(testFacture.getNouvelIndexEr()).isEqualTo(UPDATED_NOUVEL_INDEX_ER);
        assertThat(testFacture.getAncienIndexHu()).isEqualTo(UPDATED_ANCIEN_INDEX_HU);
        assertThat(testFacture.getNouvelIndexHu()).isEqualTo(UPDATED_NOUVEL_INDEX_HU);
        assertThat(testFacture.getAncienIndexIm()).isEqualTo(DEFAULT_ANCIEN_INDEX_IM);
        assertThat(testFacture.getNouvelIndexIm()).isEqualTo(UPDATED_NOUVEL_INDEX_IM);
        assertThat(testFacture.getMontantTVA7()).isEqualTo(DEFAULT_MONTANT_TVA_7);
        assertThat(testFacture.getMontantHT7()).isEqualTo(DEFAULT_MONTANT_HT_7);
        assertThat(testFacture.getMontantTVA14()).isEqualTo(DEFAULT_MONTANT_TVA_14);
        assertThat(testFacture.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testFacture.getMontantTVA20()).isEqualTo(DEFAULT_MONTANT_TVA_20);
        assertThat(testFacture.getMontantHT20()).isEqualTo(DEFAULT_MONTANT_HT_20);
        assertThat(testFacture.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testFacture.getDiversesTaxes()).isEqualTo(UPDATED_DIVERSES_TAXES);
    }

    @Test
    @Transactional
    void fullUpdateFactureWithPatch() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        int databaseSizeBeforeUpdate = factureRepository.findAll().size();

        // Update the facture using partial update
        Facture partialUpdatedFacture = new Facture();
        partialUpdatedFacture.setId(facture.getId());

        partialUpdatedFacture
            .idIOC(UPDATED_ID_IOC)
            .numeroFacture(UPDATED_NUMERO_FACTURE)
            .dateFacture(UPDATED_DATE_FACTURE)
            .codeMemoire(UPDATED_CODE_MEMOIRE)
            .idMemoire(UPDATED_ID_MEMOIRE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .typeIndex(UPDATED_TYPE_INDEX)
            .ancienIndex(UPDATED_ANCIEN_INDEX)
            .nouvelIndex(UPDATED_NOUVEL_INDEX)
            .dateDebutConso(UPDATED_DATE_DEBUT_CONSO)
            .dateFinConso(UPDATED_DATE_FIN_CONSO)
            .periodes(UPDATED_PERIODES)
            .periodeReference(UPDATED_PERIODE_REFERENCE)
            .categorieFacture(UPDATED_CATEGORIE_FACTURE)
            .puissanceAppelee(UPDATED_PUISSANCE_APPELEE)
            .cosPhi(UPDATED_COS_PHI)
            .rdpc(UPDATED_RDPC)
            .ancienIndexEan(UPDATED_ANCIEN_INDEX_EAN)
            .nouvelIndexEan(UPDATED_NOUVEL_INDEX_EAN)
            .eaNormale(UPDATED_EA_NORMALE)
            .ancienIndexEac(UPDATED_ANCIEN_INDEX_EAC)
            .nouvelIndexEac(UPDATED_NOUVEL_INDEX_EAC)
            .eaCreuse(UPDATED_EA_CREUSE)
            .ancienIndexEap(UPDATED_ANCIEN_INDEX_EAP)
            .nouvelIndexEap(UPDATED_NOUVEL_INDEX_EAP)
            .eaPointes(UPDATED_EA_POINTES)
            .energieReactive(UPDATED_ENERGIE_REACTIVE)
            .heuresUtilisees(UPDATED_HEURES_UTILISEES)
            .indiceMaximal(UPDATED_INDICE_MAXIMAL)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .dateSuppression(UPDATED_DATE_SUPPRESSION)
            .dateRendreFactureAs(UPDATED_DATE_RENDRE_FACTURE_AS)
            .statutFacture(UPDATED_STATUT_FACTURE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateValidation(UPDATED_DATE_VALIDATION)
            .dateRejet(UPDATED_DATE_REJET)
            .idUserCreation(UPDATED_ID_USER_CREATION)
            .idUserValidation(UPDATED_ID_USER_VALIDATION)
            .idUserRejet(UPDATED_ID_USER_REJET)
            .idUserModification(UPDATED_ID_USER_MODIFICATION)
            .idUserSuppression(UPDATED_ID_USER_SUPPRESSION)
            .idUserRendreFactureAs(UPDATED_ID_USER_RENDRE_FACTURE_AS)
            .observation(UPDATED_OBSERVATION)
            .motifRejet(UPDATED_MOTIF_REJET)
            .rejetMotif(UPDATED_REJET_MOTIF)
            .ancienIndexEa(UPDATED_ANCIEN_INDEX_EA)
            .nouvelIndexEa(UPDATED_NOUVEL_INDEX_EA)
            .ancienIndexEr(UPDATED_ANCIEN_INDEX_ER)
            .nouvelIndexEr(UPDATED_NOUVEL_INDEX_ER)
            .ancienIndexHu(UPDATED_ANCIEN_INDEX_HU)
            .nouvelIndexHu(UPDATED_NOUVEL_INDEX_HU)
            .ancienIndexIm(UPDATED_ANCIEN_INDEX_IM)
            .nouvelIndexIm(UPDATED_NOUVEL_INDEX_IM)
            .montantTVA7(UPDATED_MONTANT_TVA_7)
            .montantHT7(UPDATED_MONTANT_HT_7)
            .montantTVA14(UPDATED_MONTANT_TVA_14)
            .montantHT14(UPDATED_MONTANT_HT_14)
            .montantTVA20(UPDATED_MONTANT_TVA_20)
            .montantHT20(UPDATED_MONTANT_HT_20)
            .montantTvaManue(UPDATED_MONTANT_TVA_MANUE)
            .diversesTaxes(UPDATED_DIVERSES_TAXES);

        restFactureMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFacture.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFacture))
            )
            .andExpect(status().isOk());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
        Facture testFacture = factureList.get(factureList.size() - 1);
        assertThat(testFacture.getIdIOC()).isEqualTo(UPDATED_ID_IOC);
        assertThat(testFacture.getNumeroFacture()).isEqualTo(UPDATED_NUMERO_FACTURE);
        assertThat(testFacture.getDateFacture()).isEqualTo(UPDATED_DATE_FACTURE);
        assertThat(testFacture.getCodeMemoire()).isEqualTo(UPDATED_CODE_MEMOIRE);
        assertThat(testFacture.getIdMemoire()).isEqualTo(UPDATED_ID_MEMOIRE);
        assertThat(testFacture.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testFacture.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testFacture.getAncienIndex()).isEqualTo(UPDATED_ANCIEN_INDEX);
        assertThat(testFacture.getNouvelIndex()).isEqualTo(UPDATED_NOUVEL_INDEX);
        assertThat(testFacture.getDateDebutConso()).isEqualTo(UPDATED_DATE_DEBUT_CONSO);
        assertThat(testFacture.getDateFinConso()).isEqualTo(UPDATED_DATE_FIN_CONSO);
        assertThat(testFacture.getPeriodes()).isEqualTo(UPDATED_PERIODES);
        assertThat(testFacture.getPeriodeReference()).isEqualTo(UPDATED_PERIODE_REFERENCE);
        assertThat(testFacture.getCategorieFacture()).isEqualTo(UPDATED_CATEGORIE_FACTURE);
        assertThat(testFacture.getPuissanceAppelee()).isEqualTo(UPDATED_PUISSANCE_APPELEE);
        assertThat(testFacture.getCosPhi()).isEqualTo(UPDATED_COS_PHI);
        assertThat(testFacture.getRdpc()).isEqualTo(UPDATED_RDPC);
        assertThat(testFacture.getAncienIndexEan()).isEqualTo(UPDATED_ANCIEN_INDEX_EAN);
        assertThat(testFacture.getNouvelIndexEan()).isEqualTo(UPDATED_NOUVEL_INDEX_EAN);
        assertThat(testFacture.getEaNormale()).isEqualTo(UPDATED_EA_NORMALE);
        assertThat(testFacture.getAncienIndexEac()).isEqualTo(UPDATED_ANCIEN_INDEX_EAC);
        assertThat(testFacture.getNouvelIndexEac()).isEqualTo(UPDATED_NOUVEL_INDEX_EAC);
        assertThat(testFacture.getEaCreuse()).isEqualTo(UPDATED_EA_CREUSE);
        assertThat(testFacture.getAncienIndexEap()).isEqualTo(UPDATED_ANCIEN_INDEX_EAP);
        assertThat(testFacture.getNouvelIndexEap()).isEqualTo(UPDATED_NOUVEL_INDEX_EAP);
        assertThat(testFacture.getEaPointes()).isEqualTo(UPDATED_EA_POINTES);
        assertThat(testFacture.getEnergieReactive()).isEqualTo(UPDATED_ENERGIE_REACTIVE);
        assertThat(testFacture.getHeuresUtilisees()).isEqualTo(UPDATED_HEURES_UTILISEES);
        assertThat(testFacture.getIndiceMaximal()).isEqualTo(UPDATED_INDICE_MAXIMAL);
        assertThat(testFacture.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testFacture.getDateSuppression()).isEqualTo(UPDATED_DATE_SUPPRESSION);
        assertThat(testFacture.getDateRendreFactureAs()).isEqualTo(UPDATED_DATE_RENDRE_FACTURE_AS);
        assertThat(testFacture.getStatutFacture()).isEqualTo(UPDATED_STATUT_FACTURE);
        assertThat(testFacture.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testFacture.getDateValidation()).isEqualTo(UPDATED_DATE_VALIDATION);
        assertThat(testFacture.getDateRejet()).isEqualTo(UPDATED_DATE_REJET);
        assertThat(testFacture.getIdUserCreation()).isEqualTo(UPDATED_ID_USER_CREATION);
        assertThat(testFacture.getIdUserValidation()).isEqualTo(UPDATED_ID_USER_VALIDATION);
        assertThat(testFacture.getIdUserRejet()).isEqualTo(UPDATED_ID_USER_REJET);
        assertThat(testFacture.getIdUserModification()).isEqualTo(UPDATED_ID_USER_MODIFICATION);
        assertThat(testFacture.getIdUserSuppression()).isEqualTo(UPDATED_ID_USER_SUPPRESSION);
        assertThat(testFacture.getIdUserRendreFactureAs()).isEqualTo(UPDATED_ID_USER_RENDRE_FACTURE_AS);
        assertThat(testFacture.getObservation()).isEqualTo(UPDATED_OBSERVATION);
        assertThat(testFacture.getMotifRejet()).isEqualTo(UPDATED_MOTIF_REJET);
        assertThat(testFacture.getRejetMotif()).isEqualTo(UPDATED_REJET_MOTIF);
        assertThat(testFacture.getAncienIndexEa()).isEqualTo(UPDATED_ANCIEN_INDEX_EA);
        assertThat(testFacture.getNouvelIndexEa()).isEqualTo(UPDATED_NOUVEL_INDEX_EA);
        assertThat(testFacture.getAncienIndexEr()).isEqualTo(UPDATED_ANCIEN_INDEX_ER);
        assertThat(testFacture.getNouvelIndexEr()).isEqualTo(UPDATED_NOUVEL_INDEX_ER);
        assertThat(testFacture.getAncienIndexHu()).isEqualTo(UPDATED_ANCIEN_INDEX_HU);
        assertThat(testFacture.getNouvelIndexHu()).isEqualTo(UPDATED_NOUVEL_INDEX_HU);
        assertThat(testFacture.getAncienIndexIm()).isEqualTo(UPDATED_ANCIEN_INDEX_IM);
        assertThat(testFacture.getNouvelIndexIm()).isEqualTo(UPDATED_NOUVEL_INDEX_IM);
        assertThat(testFacture.getMontantTVA7()).isEqualTo(UPDATED_MONTANT_TVA_7);
        assertThat(testFacture.getMontantHT7()).isEqualTo(UPDATED_MONTANT_HT_7);
        assertThat(testFacture.getMontantTVA14()).isEqualTo(UPDATED_MONTANT_TVA_14);
        assertThat(testFacture.getMontantHT14()).isEqualTo(UPDATED_MONTANT_HT_14);
        assertThat(testFacture.getMontantTVA20()).isEqualTo(UPDATED_MONTANT_TVA_20);
        assertThat(testFacture.getMontantHT20()).isEqualTo(UPDATED_MONTANT_HT_20);
        assertThat(testFacture.getMontantTvaManue()).isEqualTo(UPDATED_MONTANT_TVA_MANUE);
        assertThat(testFacture.getDiversesTaxes()).isEqualTo(UPDATED_DIVERSES_TAXES);
    }

    @Test
    @Transactional
    void patchNonExistingFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, factureDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFacture() throws Exception {
        int databaseSizeBeforeUpdate = factureRepository.findAll().size();
        facture.setId(count.incrementAndGet());

        // Create the Facture
        FactureDTO factureDTO = factureMapper.toDto(facture);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFactureMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(factureDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Facture in the database
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFacture() throws Exception {
        // Initialize the database
        factureRepository.saveAndFlush(facture);

        int databaseSizeBeforeDelete = factureRepository.findAll().size();

        // Delete the facture
        restFactureMockMvc
            .perform(delete(ENTITY_API_URL_ID, facture.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Facture> factureList = factureRepository.findAll();
        assertThat(factureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
