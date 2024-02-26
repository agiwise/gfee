package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.IocDLC;
import ma.iam.wissal.gfee.service.dto.IocDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link IocDLC} and its DTO {@link IocDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IocDLCMapper extends EntityMapper<IocDLCDTO, IocDLC> {}
