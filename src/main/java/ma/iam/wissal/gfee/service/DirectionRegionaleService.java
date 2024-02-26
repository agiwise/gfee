package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.DirectionRegionaleDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.DirectionRegionale}.
 */
public interface DirectionRegionaleService {
    /**
     * Save a directionRegionale.
     *
     * @param directionRegionaleDTO the entity to save.
     * @return the persisted entity.
     */
    DirectionRegionaleDTO save(DirectionRegionaleDTO directionRegionaleDTO);

    /**
     * Partially updates a directionRegionale.
     *
     * @param directionRegionaleDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DirectionRegionaleDTO> partialUpdate(DirectionRegionaleDTO directionRegionaleDTO);

    /**
     * Get all the directionRegionales.
     *
     * @return the list of entities.
     */
    List<DirectionRegionaleDTO> findAll();

    /**
     * Get the "id" directionRegionale.
     *
     * @param id the id of the entity.
     * @return the entity.
     * @throws Exception 
     * @throws RuntimeException 
     */
    DirectionRegionaleDTO findOne(Long id) throws RuntimeException, Exception;

    /**
     * Delete the "id" directionRegionale.
     *
     * @param id the id of the entity.
     * @throws Exception 
     * @throws RuntimeException 
     */
    void delete(Long id) throws RuntimeException, Exception;
}
