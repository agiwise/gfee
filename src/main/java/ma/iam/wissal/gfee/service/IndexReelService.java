package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.IndexReelDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.IndexReel}.
 */
public interface IndexReelService {
    /**
     * Save a indexReel.
     *
     * @param indexReelDTO the entity to save.
     * @return the persisted entity.
     */
    IndexReelDTO save(IndexReelDTO indexReelDTO);

    /**
     * Partially updates a indexReel.
     *
     * @param indexReelDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<IndexReelDTO> partialUpdate(IndexReelDTO indexReelDTO);

    /**
     * Get all the indexReels.
     *
     * @return the list of entities.
     */
    List<IndexReelDTO> findAll();

    /**
     * Get the "id" indexReel.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IndexReelDTO> findOne(Long id);

    /**
     * Delete the "id" indexReel.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
