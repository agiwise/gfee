package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.Ville;
import ma.iam.wissal.gfee.service.dto.VilleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ville} and its DTO {@link VilleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VilleMapper extends EntityMapper<VilleDTO, Ville> {}
