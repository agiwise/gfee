package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.IOC;
import ma.iam.wissal.service.dto.IOCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link IOC} and its DTO {@link IOCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IOCMapper extends EntityMapper<IOCDTO, IOC> {}
