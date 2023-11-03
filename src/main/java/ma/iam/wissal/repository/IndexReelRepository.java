package ma.iam.wissal.repository;

import ma.iam.wissal.domain.IndexReel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the IndexReel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IndexReelRepository extends JpaRepository<IndexReel, Long> {}
