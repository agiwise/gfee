package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.UserDLCDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.UserDLC}.
 */
public interface UserDLCService {
    /**
     * Save a userDLC.
     *
     * @param userDLCDTO the entity to save.
     * @return the persisted entity.
     */
    UserDLCDTO save(UserDLCDTO userDLCDTO);

    /**
     * Partially updates a userDLC.
     *
     * @param userDLCDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserDLCDTO> partialUpdate(UserDLCDTO userDLCDTO);

    /**
     * Get all the userDLCS.
     *
     * @return the list of entities.
     */
    List<UserDLCDTO> findAll();

    /**
     * Get the "id" userDLC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserDLCDTO> findOne(Long id);

    /**
     * Delete the "id" userDLC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
