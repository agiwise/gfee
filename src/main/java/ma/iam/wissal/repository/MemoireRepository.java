package ma.iam.wissal.repository;

import ma.iam.wissal.domain.Memoire;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Memoire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemoireRepository extends JpaRepository<Memoire, Long> {}
