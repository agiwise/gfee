package ma.iam.wissal.gfee.repository;

import ma.iam.wissal.gfee.domain.IocDLC;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the IocDLC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IocDLCRepository extends JpaRepository<IocDLC, Long> {}
