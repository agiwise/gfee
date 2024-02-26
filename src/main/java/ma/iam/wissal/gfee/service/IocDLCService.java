package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.IocDLCDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.IocDLC}.
 */
public interface IocDLCService {
    /**
     * Save a iocDLC.
     *
     * @param iocDLCDTO the entity to save.
     * @return the persisted entity.
     */
    IocDLCDTO save(IocDLCDTO iocDLCDTO);

    /**
     * Partially updates a iocDLC.
     *
     * @param iocDLCDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<IocDLCDTO> partialUpdate(IocDLCDTO iocDLCDTO);

    /**
     * Get all the iocDLCS.
     *
     * @return the list of entities.
     */
    List<IocDLCDTO> findAll();

    /**
     * Get the "id" iocDLC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IocDLCDTO> findOne(Long id);

    /**
     * Delete the "id" iocDLC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
