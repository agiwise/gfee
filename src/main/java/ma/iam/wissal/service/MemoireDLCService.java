package ma.iam.wissal.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.service.dto.MemoireDLCDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.domain.MemoireDLC}.
 */
public interface MemoireDLCService {
    /**
     * Save a memoireDLC.
     *
     * @param memoireDLCDTO the entity to save.
     * @return the persisted entity.
     */
    MemoireDLCDTO save(MemoireDLCDTO memoireDLCDTO);

    /**
     * Partially updates a memoireDLC.
     *
     * @param memoireDLCDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MemoireDLCDTO> partialUpdate(MemoireDLCDTO memoireDLCDTO);

    /**
     * Get all the memoireDLCS.
     *
     * @return the list of entities.
     */
    List<MemoireDLCDTO> findAll();

    /**
     * Get the "id" memoireDLC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MemoireDLCDTO> findOne(Long id);

    /**
     * Delete the "id" memoireDLC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
