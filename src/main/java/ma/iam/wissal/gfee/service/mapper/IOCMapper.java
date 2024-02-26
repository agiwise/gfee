package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.IOC;
import ma.iam.wissal.gfee.service.dto.IOCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link IOC} and its DTO {@link IOCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IOCMapper extends EntityMapper<IOCDTO, IOC> {}
