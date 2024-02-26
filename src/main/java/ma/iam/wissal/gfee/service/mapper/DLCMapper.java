package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.DLC;
import ma.iam.wissal.gfee.service.dto.DLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DLC} and its DTO {@link DLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DLCMapper extends EntityMapper<DLCDTO, DLC> {}
