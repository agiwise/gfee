package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.MemoireDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.Memoire}.
 */
public interface MemoireService {
    /**
     * Save a memoire.
     *
     * @param memoireDTO the entity to save.
     * @return the persisted entity.
     */
    MemoireDTO save(MemoireDTO memoireDTO);

    /**
     * Partially updates a memoire.
     *
     * @param memoireDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MemoireDTO> partialUpdate(MemoireDTO memoireDTO);

    /**
     * Get all the memoires.
     *
     * @return the list of entities.
     */
    List<MemoireDTO> findAll();

    /**
     * Get the "id" memoire.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MemoireDTO> findOne(Long id);

    /**
     * Delete the "id" memoire.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
