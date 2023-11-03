package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.DirectionRegionale;
import ma.iam.wissal.service.dto.DirectionRegionaleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DirectionRegionale} and its DTO {@link DirectionRegionaleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DirectionRegionaleMapper extends EntityMapper<DirectionRegionaleDTO, DirectionRegionale> {}
