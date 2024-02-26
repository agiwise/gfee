package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.FournisseurDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.Fournisseur}.
 */
public interface FournisseurService {
    /**
     * Save a fournisseur.
     *
     * @param fournisseurDTO the entity to save.
     * @return the persisted entity.
     */
    FournisseurDTO save(FournisseurDTO fournisseurDTO);

    /**
     * Partially updates a fournisseur.
     *
     * @param fournisseurDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FournisseurDTO> partialUpdate(FournisseurDTO fournisseurDTO);

    /**
     * Get all the fournisseurs.
     *
     * @return the list of entities.
     */
    List<FournisseurDTO> findAll();

    /**
     * Get the "id" fournisseur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FournisseurDTO> findOne(Long id);

    /**
     * Delete the "id" fournisseur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
