package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.IocDLC;
import ma.iam.wissal.service.dto.IocDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link IocDLC} and its DTO {@link IocDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IocDLCMapper extends EntityMapper<IocDLCDTO, IocDLC> {}
