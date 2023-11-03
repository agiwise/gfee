package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.Ville;
import ma.iam.wissal.service.dto.VilleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ville} and its DTO {@link VilleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VilleMapper extends EntityMapper<VilleDTO, Ville> {}
