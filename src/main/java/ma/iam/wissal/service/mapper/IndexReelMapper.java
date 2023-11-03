package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.IndexReel;
import ma.iam.wissal.service.dto.IndexReelDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link IndexReel} and its DTO {@link IndexReelDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IndexReelMapper extends EntityMapper<IndexReelDTO, IndexReel> {}
