package ma.iam.wissal.gfee.repository;

import ma.iam.wissal.gfee.domain.UserDLC;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the UserDLC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserDLCRepository extends JpaRepository<UserDLC, Long> {}
