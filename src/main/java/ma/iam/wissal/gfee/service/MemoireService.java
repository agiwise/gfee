package ma.iam.wissal.gfee.service;

import java.util.List;
import java.util.Optional;
import ma.iam.wissal.gfee.service.dto.MemoireDTO;

/**
 * Service Interface for managing {@link ma.iam.wissal.gfee.domain.Memoire}.
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
     * @throws Exception 
     * @throws RuntimeException 
     */
    MemoireDTO findOne(Long id) throws RuntimeException, Exception;

    /**
     * Delete the "id" memoire.
     *
     * @param id the id of the entity.
     * @throws Exception 
     * @throws RuntimeException 
     */
    void delete(Long id) throws RuntimeException, Exception;
}
