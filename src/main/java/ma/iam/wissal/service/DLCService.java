package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.DLCDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.DLC}.
 */
public interface DLCService {
    /**
     * Save a dLC.
     *
     * @param dLCDTO the entity to save.
     * @return the persisted entity.
     */
    DLCDTO save(DLCDTO dLCDTO);

    /**
     * Partially updates a dLC.
     *
     * @param dLCDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DLCDTO> partialUpdate(DLCDTO dLCDTO);

    /**
     * Get all the dLCS.
     *
     * @return the list of entities.
     */
    List<DLCDTO> findAll();

    /**
     * Get the "id" dLC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DLCDTO> findOne(Long id);

    /**
     * Delete the "id" dLC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
