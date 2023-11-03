package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.PIECESAP;
import ma.iam.wissal.service.dto.PIECESAPDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PIECESAP} and its DTO {@link PIECESAPDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PIECESAPMapper extends EntityMapper<PIECESAPDTO, PIECESAP> {}
