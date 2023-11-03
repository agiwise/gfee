package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.UserDLC;
import ma.iam.wissal.service.dto.UserDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserDLC} and its DTO {@link UserDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserDLCMapper extends EntityMapper<UserDLCDTO, UserDLC> {}
