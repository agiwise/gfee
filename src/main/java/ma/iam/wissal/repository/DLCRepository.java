package ma.iam.wissal.repository;

import ma.iam.wissal.domain.DLC;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the DLC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {}
