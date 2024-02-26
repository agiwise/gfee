package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.PIECESAP;
import ma.iam.wissal.gfee.service.dto.PIECESAPDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PIECESAP} and its DTO {@link PIECESAPDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PIECESAPMapper extends EntityMapper<PIECESAPDTO, PIECESAP> {}
