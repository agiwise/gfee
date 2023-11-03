package ma.iam.wissal.service.mapper;

import ma.iam.wissal.domain.Memoire;
import ma.iam.wissal.service.dto.MemoireDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Memoire} and its DTO {@link MemoireDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MemoireMapper extends EntityMapper<MemoireDTO, Memoire> {}
