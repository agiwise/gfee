package ma.iam.wissal.repository;

import ma.iam.wissal.domain.PIECESAP;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PIECESAP entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PIECESAPRepository extends JpaRepository<PIECESAP, Long> {}
