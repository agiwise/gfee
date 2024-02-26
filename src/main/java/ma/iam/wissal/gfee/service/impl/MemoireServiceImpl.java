package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ma.iam.wissal.gfee.business.MemoireLocalService;
import ma.iam.wissal.gfee.domain.DirectionRegionale;
import ma.iam.wissal.gfee.domain.Memoire;
import ma.iam.wissal.gfee.repository.MemoireRepository;
import ma.iam.wissal.gfee.service.MemoireService;
import ma.iam.wissal.gfee.service.dto.DirectionRegionaleDTO;
import ma.iam.wissal.gfee.service.dto.MemoireDTO;
import ma.iam.wissal.gfee.service.mapper.MemoireMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Memoire}.
 */
@Service
@Transactional
public class MemoireServiceImpl implements MemoireService {

    private final Logger log = LoggerFactory.getLogger(MemoireServiceImpl.class);

    private final MemoireRepository memoireRepository;

    private final MemoireMapper memoireMapper;
    
    private final MemoireLocalService memoireLocalService;

    public MemoireServiceImpl(MemoireRepository memoireRepository, MemoireMapper memoireMapper, MemoireLocalService memoireLocalService) {
        this.memoireRepository = memoireRepository;
        this.memoireMapper = memoireMapper;
        this.memoireLocalService = memoireLocalService;
    }

    @Override
    public MemoireDTO save(MemoireDTO memoireDTO) {
        log.debug("Request to save Memoire : {}", memoireDTO);
        Memoire memoire = memoireMapper.toEntity(memoireDTO);
        memoire = memoireLocalService.addMemoire(memoire);
        return memoireMapper.toDto(memoire);
    }


    @Override
    @Transactional(readOnly = true)
    public List<MemoireDTO> findAll() {
        log.debug("Request to get all Memoires");
        return memoireLocalService.getMemoires().stream().map(memoireMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public MemoireDTO findOne(Long id) throws RuntimeException, Exception {
        log.debug("Request to get Memoire : {}", id);
        Memoire memoire = memoireLocalService.getMemoire(id);
        if (memoire != null) {
        	return memoireMapper.toDto(memoire);
        }
        return null;
    }
    
    @Override
    public void delete(Long id) throws RuntimeException, Exception {
        log.debug("Request to delete Memoire : {}", id);
        memoireLocalService.deleteMemoire(id);
    }
}
