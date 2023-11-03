package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.VilleDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.Ville}.
 */
public interface VilleService {
    /**
     * Save a ville.
     *
     * @param villeDTO the entity to save.
     * @return the persisted entity.
     */
    VilleDTO save(VilleDTO villeDTO);

    /**
     * Partially updates a ville.
     *
     * @param villeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VilleDTO> partialUpdate(VilleDTO villeDTO);

    /**
     * Get all the villes.
     *
     * @return the list of entities.
     */
    List<VilleDTO> findAll();

    /**
     * Get the "id" ville.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VilleDTO> findOne(Long id);

    /**
     * Delete the "id" ville.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
