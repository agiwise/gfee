package ma.iam.wissal.gfee.repository;

import ma.iam.wissal.gfee.domain.DLC;
import ma.iam.wissal.gfee.service.dto.DLCDTO;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the DLC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {

	List<DLCDTO> findDlcsByIdDirectionRegionale(Long idDirection);}
