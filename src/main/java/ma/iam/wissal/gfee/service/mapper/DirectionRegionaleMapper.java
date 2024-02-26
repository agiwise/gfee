package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.DirectionRegionale;
import ma.iam.wissal.gfee.service.dto.DirectionRegionaleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DirectionRegionale} and its DTO {@link DirectionRegionaleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DirectionRegionaleMapper extends EntityMapper<DirectionRegionaleDTO, DirectionRegionale> {}
