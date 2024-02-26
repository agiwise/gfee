package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.Facture;
import ma.iam.wissal.gfee.service.dto.FactureDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Facture} and its DTO {@link FactureDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FactureMapper extends EntityMapper<FactureDTO, Facture> {}
