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
import ma.iam.wissal.domain.IOC;
import ma.iam.wissal.repository.IOCRepository;
import ma.iam.wissal.service.dto.IOCDTO;
import ma.iam.wissal.service.mapper.IOCMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link IOCResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class IOCResourceIT {

    private static final String DEFAULT_NUMERO_IOC = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO_IOC = "BBBBBBBBBB";

    private static final Integer DEFAULT_TYPE_IOC = 1;
    private static final Integer UPDATED_TYPE_IOC = 2;

    private static final Integer DEFAULT_TYPE_PRESTATION = 1;
    private static final Integer UPDATED_TYPE_PRESTATION = 2;

    private static final Integer DEFAULT_TYPE_INDEX = 1;
    private static final Integer UPDATED_TYPE_INDEX = 2;

    private static final Integer DEFAULT_CATEGORIE = 1;
    private static final Integer UPDATED_CATEGORIE = 2;

    private static final Integer DEFAULT_ETAT_IOC = 1;
    private static final Integer UPDATED_ETAT_IOC = 2;

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESSE = "AAAAAAAAAA";
    private static final String UPDATED_ADRESSE = "BBBBBBBBBB";

    private static final String DEFAULT_PUISSANCE_SOUSCRITE = "AAAAAAAAAA";
    private static final String UPDATED_PUISSANCE_SOUSCRITE = "BBBBBBBBBB";

    private static final String DEFAULT_PUISSANCE_INSTALLE = "AAAAAAAAAA";
    private static final String UPDATED_PUISSANCE_INSTALLE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_MODIFICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_MODIFICATION = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_ID_DIRECTION_REGIONALE = 1L;
    private static final Long UPDATED_ID_DIRECTION_REGIONALE = 2L;

    private static final Long DEFAULT_ID_DLC = 1L;
    private static final Long UPDATED_ID_DLC = 2L;

    private static final Long DEFAULT_ID_VILLE = 1L;
    private static final Long UPDATED_ID_VILLE = 2L;

    private static final Integer DEFAULT_TENSION = 1;
    private static final Integer UPDATED_TENSION = 2;

    private static final String DEFAULT_RESPONSABLE_SITE = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSABLE_SITE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ACTIVITE_ANALYTIQUE = 1;
    private static final Integer UPDATED_ACTIVITE_ANALYTIQUE = 2;

    private static final String DEFAULT_CODE_ANALYTIQUE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_ANALYTIQUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CATEGORIE_INDEX = 1;
    private static final Integer UPDATED_CATEGORIE_INDEX = 2;

    private static final Long DEFAULT_ID_FOURNISSEUR = 1L;
    private static final Long UPDATED_ID_FOURNISSEUR = 2L;

    private static final Integer DEFAULT_PERIODICITE = 1;
    private static final Integer UPDATED_PERIODICITE = 2;

    private static final String DEFAULT_OBSERVATION = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/iocs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private IOCRepository iOCRepository;

    @Autowired
    private IOCMapper iOCMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIOCMockMvc;

    private IOC iOC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IOC createEntity(EntityManager em) {
        IOC iOC = new IOC()
            .numeroIOC(DEFAULT_NUMERO_IOC)
            .typeIOC(DEFAULT_TYPE_IOC)
            .typePrestation(DEFAULT_TYPE_PRESTATION)
            .typeIndex(DEFAULT_TYPE_INDEX)
            .categorie(DEFAULT_CATEGORIE)
            .etatIOC(DEFAULT_ETAT_IOC)
            .libelle(DEFAULT_LIBELLE)
            .adresse(DEFAULT_ADRESSE)
            .puissanceSouscrite(DEFAULT_PUISSANCE_SOUSCRITE)
            .puissanceInstalle(DEFAULT_PUISSANCE_INSTALLE)
            .dateCreation(DEFAULT_DATE_CREATION)
            .dateModification(DEFAULT_DATE_MODIFICATION)
            .idDirectionRegionale(DEFAULT_ID_DIRECTION_REGIONALE)
            .idDLC(DEFAULT_ID_DLC)
            .idVille(DEFAULT_ID_VILLE)
            .tension(DEFAULT_TENSION)
            .responsableSite(DEFAULT_RESPONSABLE_SITE)
            .activiteAnalytique(DEFAULT_ACTIVITE_ANALYTIQUE)
            .codeAnalytique(DEFAULT_CODE_ANALYTIQUE)
            .categorieIndex(DEFAULT_CATEGORIE_INDEX)
            .idFournisseur(DEFAULT_ID_FOURNISSEUR)
            .periodicite(DEFAULT_PERIODICITE)
            .observation(DEFAULT_OBSERVATION);
        return iOC;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IOC createUpdatedEntity(EntityManager em) {
        IOC iOC = new IOC()
            .numeroIOC(UPDATED_NUMERO_IOC)
            .typeIOC(UPDATED_TYPE_IOC)
            .typePrestation(UPDATED_TYPE_PRESTATION)
            .typeIndex(UPDATED_TYPE_INDEX)
            .categorie(UPDATED_CATEGORIE)
            .etatIOC(UPDATED_ETAT_IOC)
            .libelle(UPDATED_LIBELLE)
            .adresse(UPDATED_ADRESSE)
            .puissanceSouscrite(UPDATED_PUISSANCE_SOUSCRITE)
            .puissanceInstalle(UPDATED_PUISSANCE_INSTALLE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .tension(UPDATED_TENSION)
            .responsableSite(UPDATED_RESPONSABLE_SITE)
            .activiteAnalytique(UPDATED_ACTIVITE_ANALYTIQUE)
            .codeAnalytique(UPDATED_CODE_ANALYTIQUE)
            .categorieIndex(UPDATED_CATEGORIE_INDEX)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .periodicite(UPDATED_PERIODICITE)
            .observation(UPDATED_OBSERVATION);
        return iOC;
    }

    @BeforeEach
    public void initTest() {
        iOC = createEntity(em);
    }

    @Test
    @Transactional
    void createIOC() throws Exception {
        int databaseSizeBeforeCreate = iOCRepository.findAll().size();
        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);
        restIOCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iOCDTO)))
            .andExpect(status().isCreated());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeCreate + 1);
        IOC testIOC = iOCList.get(iOCList.size() - 1);
        assertThat(testIOC.getNumeroIOC()).isEqualTo(DEFAULT_NUMERO_IOC);
        assertThat(testIOC.getTypeIOC()).isEqualTo(DEFAULT_TYPE_IOC);
        assertThat(testIOC.getTypePrestation()).isEqualTo(DEFAULT_TYPE_PRESTATION);
        assertThat(testIOC.getTypeIndex()).isEqualTo(DEFAULT_TYPE_INDEX);
        assertThat(testIOC.getCategorie()).isEqualTo(DEFAULT_CATEGORIE);
        assertThat(testIOC.getEtatIOC()).isEqualTo(DEFAULT_ETAT_IOC);
        assertThat(testIOC.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testIOC.getAdresse()).isEqualTo(DEFAULT_ADRESSE);
        assertThat(testIOC.getPuissanceSouscrite()).isEqualTo(DEFAULT_PUISSANCE_SOUSCRITE);
        assertThat(testIOC.getPuissanceInstalle()).isEqualTo(DEFAULT_PUISSANCE_INSTALLE);
        assertThat(testIOC.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testIOC.getDateModification()).isEqualTo(DEFAULT_DATE_MODIFICATION);
        assertThat(testIOC.getIdDirectionRegionale()).isEqualTo(DEFAULT_ID_DIRECTION_REGIONALE);
        assertThat(testIOC.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
        assertThat(testIOC.getIdVille()).isEqualTo(DEFAULT_ID_VILLE);
        assertThat(testIOC.getTension()).isEqualTo(DEFAULT_TENSION);
        assertThat(testIOC.getResponsableSite()).isEqualTo(DEFAULT_RESPONSABLE_SITE);
        assertThat(testIOC.getActiviteAnalytique()).isEqualTo(DEFAULT_ACTIVITE_ANALYTIQUE);
        assertThat(testIOC.getCodeAnalytique()).isEqualTo(DEFAULT_CODE_ANALYTIQUE);
        assertThat(testIOC.getCategorieIndex()).isEqualTo(DEFAULT_CATEGORIE_INDEX);
        assertThat(testIOC.getIdFournisseur()).isEqualTo(DEFAULT_ID_FOURNISSEUR);
        assertThat(testIOC.getPeriodicite()).isEqualTo(DEFAULT_PERIODICITE);
        assertThat(testIOC.getObservation()).isEqualTo(DEFAULT_OBSERVATION);
    }

    @Test
    @Transactional
    void createIOCWithExistingId() throws Exception {
        // Create the IOC with an existing ID
        iOC.setId(1L);
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        int databaseSizeBeforeCreate = iOCRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restIOCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iOCDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllIOCS() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        // Get all the iOCList
        restIOCMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(iOC.getId().intValue())))
            .andExpect(jsonPath("$.[*].numeroIOC").value(hasItem(DEFAULT_NUMERO_IOC)))
            .andExpect(jsonPath("$.[*].typeIOC").value(hasItem(DEFAULT_TYPE_IOC)))
            .andExpect(jsonPath("$.[*].typePrestation").value(hasItem(DEFAULT_TYPE_PRESTATION)))
            .andExpect(jsonPath("$.[*].typeIndex").value(hasItem(DEFAULT_TYPE_INDEX)))
            .andExpect(jsonPath("$.[*].categorie").value(hasItem(DEFAULT_CATEGORIE)))
            .andExpect(jsonPath("$.[*].etatIOC").value(hasItem(DEFAULT_ETAT_IOC)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].adresse").value(hasItem(DEFAULT_ADRESSE)))
            .andExpect(jsonPath("$.[*].puissanceSouscrite").value(hasItem(DEFAULT_PUISSANCE_SOUSCRITE)))
            .andExpect(jsonPath("$.[*].puissanceInstalle").value(hasItem(DEFAULT_PUISSANCE_INSTALLE)))
            .andExpect(jsonPath("$.[*].dateCreation").value(hasItem(DEFAULT_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].dateModification").value(hasItem(DEFAULT_DATE_MODIFICATION.toString())))
            .andExpect(jsonPath("$.[*].idDirectionRegionale").value(hasItem(DEFAULT_ID_DIRECTION_REGIONALE.intValue())))
            .andExpect(jsonPath("$.[*].idDLC").value(hasItem(DEFAULT_ID_DLC.intValue())))
            .andExpect(jsonPath("$.[*].idVille").value(hasItem(DEFAULT_ID_VILLE.intValue())))
            .andExpect(jsonPath("$.[*].tension").value(hasItem(DEFAULT_TENSION)))
            .andExpect(jsonPath("$.[*].responsableSite").value(hasItem(DEFAULT_RESPONSABLE_SITE)))
            .andExpect(jsonPath("$.[*].activiteAnalytique").value(hasItem(DEFAULT_ACTIVITE_ANALYTIQUE)))
            .andExpect(jsonPath("$.[*].codeAnalytique").value(hasItem(DEFAULT_CODE_ANALYTIQUE)))
            .andExpect(jsonPath("$.[*].categorieIndex").value(hasItem(DEFAULT_CATEGORIE_INDEX)))
            .andExpect(jsonPath("$.[*].idFournisseur").value(hasItem(DEFAULT_ID_FOURNISSEUR.intValue())))
            .andExpect(jsonPath("$.[*].periodicite").value(hasItem(DEFAULT_PERIODICITE)))
            .andExpect(jsonPath("$.[*].observation").value(hasItem(DEFAULT_OBSERVATION)));
    }

    @Test
    @Transactional
    void getIOC() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        // Get the iOC
        restIOCMockMvc
            .perform(get(ENTITY_API_URL_ID, iOC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(iOC.getId().intValue()))
            .andExpect(jsonPath("$.numeroIOC").value(DEFAULT_NUMERO_IOC))
            .andExpect(jsonPath("$.typeIOC").value(DEFAULT_TYPE_IOC))
            .andExpect(jsonPath("$.typePrestation").value(DEFAULT_TYPE_PRESTATION))
            .andExpect(jsonPath("$.typeIndex").value(DEFAULT_TYPE_INDEX))
            .andExpect(jsonPath("$.categorie").value(DEFAULT_CATEGORIE))
            .andExpect(jsonPath("$.etatIOC").value(DEFAULT_ETAT_IOC))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.adresse").value(DEFAULT_ADRESSE))
            .andExpect(jsonPath("$.puissanceSouscrite").value(DEFAULT_PUISSANCE_SOUSCRITE))
            .andExpect(jsonPath("$.puissanceInstalle").value(DEFAULT_PUISSANCE_INSTALLE))
            .andExpect(jsonPath("$.dateCreation").value(DEFAULT_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.dateModification").value(DEFAULT_DATE_MODIFICATION.toString()))
            .andExpect(jsonPath("$.idDirectionRegionale").value(DEFAULT_ID_DIRECTION_REGIONALE.intValue()))
            .andExpect(jsonPath("$.idDLC").value(DEFAULT_ID_DLC.intValue()))
            .andExpect(jsonPath("$.idVille").value(DEFAULT_ID_VILLE.intValue()))
            .andExpect(jsonPath("$.tension").value(DEFAULT_TENSION))
            .andExpect(jsonPath("$.responsableSite").value(DEFAULT_RESPONSABLE_SITE))
            .andExpect(jsonPath("$.activiteAnalytique").value(DEFAULT_ACTIVITE_ANALYTIQUE))
            .andExpect(jsonPath("$.codeAnalytique").value(DEFAULT_CODE_ANALYTIQUE))
            .andExpect(jsonPath("$.categorieIndex").value(DEFAULT_CATEGORIE_INDEX))
            .andExpect(jsonPath("$.idFournisseur").value(DEFAULT_ID_FOURNISSEUR.intValue()))
            .andExpect(jsonPath("$.periodicite").value(DEFAULT_PERIODICITE))
            .andExpect(jsonPath("$.observation").value(DEFAULT_OBSERVATION));
    }

    @Test
    @Transactional
    void getNonExistingIOC() throws Exception {
        // Get the iOC
        restIOCMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewIOC() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();

        // Update the iOC
        IOC updatedIOC = iOCRepository.findById(iOC.getId()).get();
        // Disconnect from session so that the updates on updatedIOC are not directly saved in db
        em.detach(updatedIOC);
        updatedIOC
            .numeroIOC(UPDATED_NUMERO_IOC)
            .typeIOC(UPDATED_TYPE_IOC)
            .typePrestation(UPDATED_TYPE_PRESTATION)
            .typeIndex(UPDATED_TYPE_INDEX)
            .categorie(UPDATED_CATEGORIE)
            .etatIOC(UPDATED_ETAT_IOC)
            .libelle(UPDATED_LIBELLE)
            .adresse(UPDATED_ADRESSE)
            .puissanceSouscrite(UPDATED_PUISSANCE_SOUSCRITE)
            .puissanceInstalle(UPDATED_PUISSANCE_INSTALLE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .tension(UPDATED_TENSION)
            .responsableSite(UPDATED_RESPONSABLE_SITE)
            .activiteAnalytique(UPDATED_ACTIVITE_ANALYTIQUE)
            .codeAnalytique(UPDATED_CODE_ANALYTIQUE)
            .categorieIndex(UPDATED_CATEGORIE_INDEX)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .periodicite(UPDATED_PERIODICITE)
            .observation(UPDATED_OBSERVATION);
        IOCDTO iOCDTO = iOCMapper.toDto(updatedIOC);

        restIOCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, iOCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iOCDTO))
            )
            .andExpect(status().isOk());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
        IOC testIOC = iOCList.get(iOCList.size() - 1);
        assertThat(testIOC.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIOC.getTypeIOC()).isEqualTo(UPDATED_TYPE_IOC);
        assertThat(testIOC.getTypePrestation()).isEqualTo(UPDATED_TYPE_PRESTATION);
        assertThat(testIOC.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testIOC.getCategorie()).isEqualTo(UPDATED_CATEGORIE);
        assertThat(testIOC.getEtatIOC()).isEqualTo(UPDATED_ETAT_IOC);
        assertThat(testIOC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testIOC.getAdresse()).isEqualTo(UPDATED_ADRESSE);
        assertThat(testIOC.getPuissanceSouscrite()).isEqualTo(UPDATED_PUISSANCE_SOUSCRITE);
        assertThat(testIOC.getPuissanceInstalle()).isEqualTo(UPDATED_PUISSANCE_INSTALLE);
        assertThat(testIOC.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testIOC.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testIOC.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
        assertThat(testIOC.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testIOC.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testIOC.getTension()).isEqualTo(UPDATED_TENSION);
        assertThat(testIOC.getResponsableSite()).isEqualTo(UPDATED_RESPONSABLE_SITE);
        assertThat(testIOC.getActiviteAnalytique()).isEqualTo(UPDATED_ACTIVITE_ANALYTIQUE);
        assertThat(testIOC.getCodeAnalytique()).isEqualTo(UPDATED_CODE_ANALYTIQUE);
        assertThat(testIOC.getCategorieIndex()).isEqualTo(UPDATED_CATEGORIE_INDEX);
        assertThat(testIOC.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testIOC.getPeriodicite()).isEqualTo(UPDATED_PERIODICITE);
        assertThat(testIOC.getObservation()).isEqualTo(UPDATED_OBSERVATION);
    }

    @Test
    @Transactional
    void putNonExistingIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, iOCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iOCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(iOCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(iOCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateIOCWithPatch() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();

        // Update the iOC using partial update
        IOC partialUpdatedIOC = new IOC();
        partialUpdatedIOC.setId(iOC.getId());

        partialUpdatedIOC
            .typeIOC(UPDATED_TYPE_IOC)
            .typeIndex(UPDATED_TYPE_INDEX)
            .categorie(UPDATED_CATEGORIE)
            .etatIOC(UPDATED_ETAT_IOC)
            .libelle(UPDATED_LIBELLE)
            .puissanceInstalle(UPDATED_PUISSANCE_INSTALLE)
            .idVille(UPDATED_ID_VILLE)
            .tension(UPDATED_TENSION)
            .responsableSite(UPDATED_RESPONSABLE_SITE)
            .activiteAnalytique(UPDATED_ACTIVITE_ANALYTIQUE)
            .categorieIndex(UPDATED_CATEGORIE_INDEX)
            .observation(UPDATED_OBSERVATION);

        restIOCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIOC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIOC))
            )
            .andExpect(status().isOk());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
        IOC testIOC = iOCList.get(iOCList.size() - 1);
        assertThat(testIOC.getNumeroIOC()).isEqualTo(DEFAULT_NUMERO_IOC);
        assertThat(testIOC.getTypeIOC()).isEqualTo(UPDATED_TYPE_IOC);
        assertThat(testIOC.getTypePrestation()).isEqualTo(DEFAULT_TYPE_PRESTATION);
        assertThat(testIOC.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testIOC.getCategorie()).isEqualTo(UPDATED_CATEGORIE);
        assertThat(testIOC.getEtatIOC()).isEqualTo(UPDATED_ETAT_IOC);
        assertThat(testIOC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testIOC.getAdresse()).isEqualTo(DEFAULT_ADRESSE);
        assertThat(testIOC.getPuissanceSouscrite()).isEqualTo(DEFAULT_PUISSANCE_SOUSCRITE);
        assertThat(testIOC.getPuissanceInstalle()).isEqualTo(UPDATED_PUISSANCE_INSTALLE);
        assertThat(testIOC.getDateCreation()).isEqualTo(DEFAULT_DATE_CREATION);
        assertThat(testIOC.getDateModification()).isEqualTo(DEFAULT_DATE_MODIFICATION);
        assertThat(testIOC.getIdDirectionRegionale()).isEqualTo(DEFAULT_ID_DIRECTION_REGIONALE);
        assertThat(testIOC.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
        assertThat(testIOC.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testIOC.getTension()).isEqualTo(UPDATED_TENSION);
        assertThat(testIOC.getResponsableSite()).isEqualTo(UPDATED_RESPONSABLE_SITE);
        assertThat(testIOC.getActiviteAnalytique()).isEqualTo(UPDATED_ACTIVITE_ANALYTIQUE);
        assertThat(testIOC.getCodeAnalytique()).isEqualTo(DEFAULT_CODE_ANALYTIQUE);
        assertThat(testIOC.getCategorieIndex()).isEqualTo(UPDATED_CATEGORIE_INDEX);
        assertThat(testIOC.getIdFournisseur()).isEqualTo(DEFAULT_ID_FOURNISSEUR);
        assertThat(testIOC.getPeriodicite()).isEqualTo(DEFAULT_PERIODICITE);
        assertThat(testIOC.getObservation()).isEqualTo(UPDATED_OBSERVATION);
    }

    @Test
    @Transactional
    void fullUpdateIOCWithPatch() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();

        // Update the iOC using partial update
        IOC partialUpdatedIOC = new IOC();
        partialUpdatedIOC.setId(iOC.getId());

        partialUpdatedIOC
            .numeroIOC(UPDATED_NUMERO_IOC)
            .typeIOC(UPDATED_TYPE_IOC)
            .typePrestation(UPDATED_TYPE_PRESTATION)
            .typeIndex(UPDATED_TYPE_INDEX)
            .categorie(UPDATED_CATEGORIE)
            .etatIOC(UPDATED_ETAT_IOC)
            .libelle(UPDATED_LIBELLE)
            .adresse(UPDATED_ADRESSE)
            .puissanceSouscrite(UPDATED_PUISSANCE_SOUSCRITE)
            .puissanceInstalle(UPDATED_PUISSANCE_INSTALLE)
            .dateCreation(UPDATED_DATE_CREATION)
            .dateModification(UPDATED_DATE_MODIFICATION)
            .idDirectionRegionale(UPDATED_ID_DIRECTION_REGIONALE)
            .idDLC(UPDATED_ID_DLC)
            .idVille(UPDATED_ID_VILLE)
            .tension(UPDATED_TENSION)
            .responsableSite(UPDATED_RESPONSABLE_SITE)
            .activiteAnalytique(UPDATED_ACTIVITE_ANALYTIQUE)
            .codeAnalytique(UPDATED_CODE_ANALYTIQUE)
            .categorieIndex(UPDATED_CATEGORIE_INDEX)
            .idFournisseur(UPDATED_ID_FOURNISSEUR)
            .periodicite(UPDATED_PERIODICITE)
            .observation(UPDATED_OBSERVATION);

        restIOCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedIOC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedIOC))
            )
            .andExpect(status().isOk());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
        IOC testIOC = iOCList.get(iOCList.size() - 1);
        assertThat(testIOC.getNumeroIOC()).isEqualTo(UPDATED_NUMERO_IOC);
        assertThat(testIOC.getTypeIOC()).isEqualTo(UPDATED_TYPE_IOC);
        assertThat(testIOC.getTypePrestation()).isEqualTo(UPDATED_TYPE_PRESTATION);
        assertThat(testIOC.getTypeIndex()).isEqualTo(UPDATED_TYPE_INDEX);
        assertThat(testIOC.getCategorie()).isEqualTo(UPDATED_CATEGORIE);
        assertThat(testIOC.getEtatIOC()).isEqualTo(UPDATED_ETAT_IOC);
        assertThat(testIOC.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testIOC.getAdresse()).isEqualTo(UPDATED_ADRESSE);
        assertThat(testIOC.getPuissanceSouscrite()).isEqualTo(UPDATED_PUISSANCE_SOUSCRITE);
        assertThat(testIOC.getPuissanceInstalle()).isEqualTo(UPDATED_PUISSANCE_INSTALLE);
        assertThat(testIOC.getDateCreation()).isEqualTo(UPDATED_DATE_CREATION);
        assertThat(testIOC.getDateModification()).isEqualTo(UPDATED_DATE_MODIFICATION);
        assertThat(testIOC.getIdDirectionRegionale()).isEqualTo(UPDATED_ID_DIRECTION_REGIONALE);
        assertThat(testIOC.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
        assertThat(testIOC.getIdVille()).isEqualTo(UPDATED_ID_VILLE);
        assertThat(testIOC.getTension()).isEqualTo(UPDATED_TENSION);
        assertThat(testIOC.getResponsableSite()).isEqualTo(UPDATED_RESPONSABLE_SITE);
        assertThat(testIOC.getActiviteAnalytique()).isEqualTo(UPDATED_ACTIVITE_ANALYTIQUE);
        assertThat(testIOC.getCodeAnalytique()).isEqualTo(UPDATED_CODE_ANALYTIQUE);
        assertThat(testIOC.getCategorieIndex()).isEqualTo(UPDATED_CATEGORIE_INDEX);
        assertThat(testIOC.getIdFournisseur()).isEqualTo(UPDATED_ID_FOURNISSEUR);
        assertThat(testIOC.getPeriodicite()).isEqualTo(UPDATED_PERIODICITE);
        assertThat(testIOC.getObservation()).isEqualTo(UPDATED_OBSERVATION);
    }

    @Test
    @Transactional
    void patchNonExistingIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, iOCDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(iOCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(iOCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamIOC() throws Exception {
        int databaseSizeBeforeUpdate = iOCRepository.findAll().size();
        iOC.setId(count.incrementAndGet());

        // Create the IOC
        IOCDTO iOCDTO = iOCMapper.toDto(iOC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restIOCMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(iOCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the IOC in the database
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteIOC() throws Exception {
        // Initialize the database
        iOCRepository.saveAndFlush(iOC);

        int databaseSizeBeforeDelete = iOCRepository.findAll().size();

        // Delete the iOC
        restIOCMockMvc.perform(delete(ENTITY_API_URL_ID, iOC.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IOC> iOCList = iOCRepository.findAll();
        assertThat(iOCList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
