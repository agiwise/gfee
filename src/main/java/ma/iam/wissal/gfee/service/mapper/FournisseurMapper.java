package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.Fournisseur;
import ma.iam.wissal.gfee.service.dto.FournisseurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Fournisseur} and its DTO {@link FournisseurDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {}
