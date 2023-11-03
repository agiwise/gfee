package ma.iam.wissal.repository;

import ma.iam.wissal.domain.MemoireDLC;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the MemoireDLC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemoireDLCRepository extends JpaRepository<MemoireDLC, Long> {}
