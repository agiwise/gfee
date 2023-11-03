package ma.iam.wissal.repository;

import ma.iam.wissal.domain.IOC;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the IOC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IOCRepository extends JpaRepository<IOC, Long> {}
