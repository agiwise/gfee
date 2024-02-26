package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.IOCDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.IOC}.
 */
public interface IOCService {
    /**
     * Save a iOC.
     *
     * @param iOCDTO the entity to save.
     * @return the persisted entity.
     */
    IOCDTO save(IOCDTO iOCDTO);

    /**
     * Partially updates a iOC.
     *
     * @param iOCDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<IOCDTO> partialUpdate(IOCDTO iOCDTO);

    /**
     * Get all the iOCS.
     *
     * @return the list of entities.
     */
    List<IOCDTO> findAll();

    /**
     * Get the "id" iOC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IOCDTO> findOne(Long id);

    /**
     * Delete the "id" iOC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
