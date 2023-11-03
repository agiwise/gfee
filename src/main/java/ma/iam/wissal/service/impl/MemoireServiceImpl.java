package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.Memoire;
import ma.iam.wissal.repository.MemoireRepository;
import ma.iam.wissal.service.MemoireService;
import ma.iam.wissal.service.dto.MemoireDTO;
import ma.iam.wissal.service.mapper.MemoireMapper;
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

    public MemoireServiceImpl(MemoireRepository memoireRepository, MemoireMapper memoireMapper) {
        this.memoireRepository = memoireRepository;
        this.memoireMapper = memoireMapper;
    }

    @Override
    public MemoireDTO save(MemoireDTO memoireDTO) {
        log.debug("Request to save Memoire : {}", memoireDTO);
        Memoire memoire = memoireMapper.toEntity(memoireDTO);
        memoire = memoireRepository.save(memoire);
        return memoireMapper.toDto(memoire);
    }

    @Override
    public Optional<MemoireDTO> partialUpdate(MemoireDTO memoireDTO) {
        log.debug("Request to partially update Memoire : {}", memoireDTO);

        return memoireRepository
            .findById(memoireDTO.getId())
            .map(existingMemoire -> {
                memoireMapper.partialUpdate(existingMemoire, memoireDTO);

                return existingMemoire;
            })
            .map(memoireRepository::save)
            .map(memoireMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemoireDTO> findAll() {
        log.debug("Request to get all Memoires");
        return memoireRepository.findAll().stream().map(memoireMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MemoireDTO> findOne(Long id) {
        log.debug("Request to get Memoire : {}", id);
        return memoireRepository.findById(id).map(memoireMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Memoire : {}", id);
        memoireRepository.deleteById(id);
    }
}
