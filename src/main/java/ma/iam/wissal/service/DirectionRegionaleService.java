package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.DirectionRegionaleDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.DirectionRegionale}.
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
     */
    Optional<DirectionRegionaleDTO> findOne(Long id);

    /**
     * Delete the "id" directionRegionale.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
