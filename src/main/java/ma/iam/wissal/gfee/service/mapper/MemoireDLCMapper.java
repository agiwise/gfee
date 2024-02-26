package ma.iam.wissal.gfee.service.mapper;

import ma.iam.wissal.gfee.domain.MemoireDLC;
import ma.iam.wissal.gfee.service.dto.MemoireDLCDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link MemoireDLC} and its DTO {@link MemoireDLCDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MemoireDLCMapper extends EntityMapper<MemoireDLCDTO, MemoireDLC> {}
