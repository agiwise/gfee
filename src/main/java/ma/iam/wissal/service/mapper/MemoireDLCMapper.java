package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.MemoireDLC;
import ma.iam.wissal.service.dto.MemoireDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link MemoireDLC} and its DTO {@link MemoireDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MemoireDLCMapper extends EntityMapper<MemoireDLCDTO, MemoireDLC> {}
