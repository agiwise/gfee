package ma.iam.wissal.gfee.repository;

import ma.iam.wissal.gfee.domain.DirectionRegionale;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the DirectionRegionale entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DirectionRegionaleRepository extends JpaRepository<DirectionRegionale, Long> {}
