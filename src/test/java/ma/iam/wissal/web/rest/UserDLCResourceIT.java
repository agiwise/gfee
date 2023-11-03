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
import ma.iam.wissal.domain.UserDLC;
import ma.iam.wissal.repository.UserDLCRepository;
import ma.iam.wissal.service.dto.UserDLCDTO;
import ma.iam.wissal.service.mapper.UserDLCMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link UserDLCResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UserDLCResourceIT {

    private static final Long DEFAULT_ID_USER_LIFERAY = 1L;
    private static final Long UPDATED_ID_USER_LIFERAY = 2L;

    private static final Long DEFAULT_ID_DLC = 1L;
    private static final Long UPDATED_ID_DLC = 2L;

    private static final String ENTITY_API_URL = "/api/user-dlcs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UserDLCRepository userDLCRepository;

    @Autowired
    private UserDLCMapper userDLCMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUserDLCMockMvc;

    private UserDLC userDLC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDLC createEntity(EntityManager em) {
        UserDLC userDLC = new UserDLC().idUserLiferay(DEFAULT_ID_USER_LIFERAY).idDLC(DEFAULT_ID_DLC);
        return userDLC;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDLC createUpdatedEntity(EntityManager em) {
        UserDLC userDLC = new UserDLC().idUserLiferay(UPDATED_ID_USER_LIFERAY).idDLC(UPDATED_ID_DLC);
        return userDLC;
    }

    @BeforeEach
    public void initTest() {
        userDLC = createEntity(em);
    }

    @Test
    @Transactional
    void createUserDLC() throws Exception {
        int databaseSizeBeforeCreate = userDLCRepository.findAll().size();
        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);
        restUserDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userDLCDTO)))
            .andExpect(status().isCreated());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeCreate + 1);
        UserDLC testUserDLC = userDLCList.get(userDLCList.size() - 1);
        assertThat(testUserDLC.getIdUserLiferay()).isEqualTo(DEFAULT_ID_USER_LIFERAY);
        assertThat(testUserDLC.getIdDLC()).isEqualTo(DEFAULT_ID_DLC);
    }

    @Test
    @Transactional
    void createUserDLCWithExistingId() throws Exception {
        // Create the UserDLC with an existing ID
        userDLC.setId(1L);
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        int databaseSizeBeforeCreate = userDLCRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserDLCMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userDLCDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllUserDLCS() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        // Get all the userDLCList
        restUserDLCMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userDLC.getId().intValue())))
            .andExpect(jsonPath("$.[*].idUserLiferay").value(hasItem(DEFAULT_ID_USER_LIFERAY.intValue())))
            .andExpect(jsonPath("$.[*].idDLC").value(hasItem(DEFAULT_ID_DLC.intValue())));
    }

    @Test
    @Transactional
    void getUserDLC() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        // Get the userDLC
        restUserDLCMockMvc
            .perform(get(ENTITY_API_URL_ID, userDLC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(userDLC.getId().intValue()))
            .andExpect(jsonPath("$.idUserLiferay").value(DEFAULT_ID_USER_LIFERAY.intValue()))
            .andExpect(jsonPath("$.idDLC").value(DEFAULT_ID_DLC.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingUserDLC() throws Exception {
        // Get the userDLC
        restUserDLCMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewUserDLC() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();

        // Update the userDLC
        UserDLC updatedUserDLC = userDLCRepository.findById(userDLC.getId()).get();
        // Disconnect from session so that the updates on updatedUserDLC are not directly saved in db
        em.detach(updatedUserDLC);
        updatedUserDLC.idUserLiferay(UPDATED_ID_USER_LIFERAY).idDLC(UPDATED_ID_DLC);
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(updatedUserDLC);

        restUserDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, userDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isOk());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
        UserDLC testUserDLC = userDLCList.get(userDLCList.size() - 1);
        assertThat(testUserDLC.getIdUserLiferay()).isEqualTo(UPDATED_ID_USER_LIFERAY);
        assertThat(testUserDLC.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
    }

    @Test
    @Transactional
    void putNonExistingUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, userDLCDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(userDLCDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateUserDLCWithPatch() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();

        // Update the userDLC using partial update
        UserDLC partialUpdatedUserDLC = new UserDLC();
        partialUpdatedUserDLC.setId(userDLC.getId());

        partialUpdatedUserDLC.idUserLiferay(UPDATED_ID_USER_LIFERAY).idDLC(UPDATED_ID_DLC);

        restUserDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUserDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUserDLC))
            )
            .andExpect(status().isOk());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
        UserDLC testUserDLC = userDLCList.get(userDLCList.size() - 1);
        assertThat(testUserDLC.getIdUserLiferay()).isEqualTo(UPDATED_ID_USER_LIFERAY);
        assertThat(testUserDLC.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
    }

    @Test
    @Transactional
    void fullUpdateUserDLCWithPatch() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();

        // Update the userDLC using partial update
        UserDLC partialUpdatedUserDLC = new UserDLC();
        partialUpdatedUserDLC.setId(userDLC.getId());

        partialUpdatedUserDLC.idUserLiferay(UPDATED_ID_USER_LIFERAY).idDLC(UPDATED_ID_DLC);

        restUserDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUserDLC.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUserDLC))
            )
            .andExpect(status().isOk());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
        UserDLC testUserDLC = userDLCList.get(userDLCList.size() - 1);
        assertThat(testUserDLC.getIdUserLiferay()).isEqualTo(UPDATED_ID_USER_LIFERAY);
        assertThat(testUserDLC.getIdDLC()).isEqualTo(UPDATED_ID_DLC);
    }

    @Test
    @Transactional
    void patchNonExistingUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, userDLCDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamUserDLC() throws Exception {
        int databaseSizeBeforeUpdate = userDLCRepository.findAll().size();
        userDLC.setId(count.incrementAndGet());

        // Create the UserDLC
        UserDLCDTO userDLCDTO = userDLCMapper.toDto(userDLC);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUserDLCMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(userDLCDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the UserDLC in the database
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteUserDLC() throws Exception {
        // Initialize the database
        userDLCRepository.saveAndFlush(userDLC);

        int databaseSizeBeforeDelete = userDLCRepository.findAll().size();

        // Delete the userDLC
        restUserDLCMockMvc
            .perform(delete(ENTITY_API_URL_ID, userDLC.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UserDLC> userDLCList = userDLCRepository.findAll();
        assertThat(userDLCList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
