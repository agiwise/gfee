package ma.iam.wissal.gfee.repository;

import ma.iam.wissal.gfee.domain.PIECESAP;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PIECESAP entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PIECESAPRepository extends JpaRepository<PIECESAP, Long> {}
