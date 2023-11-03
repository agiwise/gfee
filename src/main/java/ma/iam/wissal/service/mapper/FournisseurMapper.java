package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.Fournisseur;
import ma.iam.wissal.service.dto.FournisseurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Fournisseur} and its DTO {@link FournisseurDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {}
