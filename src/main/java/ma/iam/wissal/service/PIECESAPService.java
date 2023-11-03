package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.PIECESAPDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.PIECESAP}.
 */
public interface PIECESAPService {
    /**
     * Save a pIECESAP.
     *
     * @param pIECESAPDTO the entity to save.
     * @return the persisted entity.
     */
    PIECESAPDTO save(PIECESAPDTO pIECESAPDTO);

    /**
     * Partially updates a pIECESAP.
     *
     * @param pIECESAPDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PIECESAPDTO> partialUpdate(PIECESAPDTO pIECESAPDTO);

    /**
     * Get all the pIECESAPS.
     *
     * @return the list of entities.
     */
    List<PIECESAPDTO> findAll();

    /**
     * Get the "id" pIECESAP.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PIECESAPDTO> findOne(Long id);

    /**
     * Delete the "id" pIECESAP.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
