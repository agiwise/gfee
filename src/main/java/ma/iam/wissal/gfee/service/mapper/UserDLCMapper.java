package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.UserDLC;
import ma.iam.wissal.gfee.service.dto.UserDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserDLC} and its DTO {@link UserDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserDLCMapper extends EntityMapper<UserDLCDTO, UserDLC> {}
