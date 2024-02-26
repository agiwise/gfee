package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.gfee.domain.MemoireDLC;
import ma.iam.wissal.gfee.repository.MemoireDLCRepository;
import ma.iam.wissal.gfee.service.MemoireDLCService;
import ma.iam.wissal.gfee.service.dto.MemoireDLCDTO;
import ma.iam.wissal.gfee.service.mapper.MemoireDLCMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MemoireDLC}.
 */
@Service
@Transactional
public class MemoireDLCServiceImpl implements MemoireDLCService {

    private final Logger log = LoggerFactory.getLogger(MemoireDLCServiceImpl.class);

    private final MemoireDLCRepository memoireDLCRepository;

    private final MemoireDLCMapper memoireDLCMapper;

    public MemoireDLCServiceImpl(MemoireDLCRepository memoireDLCRepository, MemoireDLCMapper memoireDLCMapper) {
        this.memoireDLCRepository = memoireDLCRepository;
        this.memoireDLCMapper = memoireDLCMapper;
    }

    @Override
    public MemoireDLCDTO save(MemoireDLCDTO memoireDLCDTO) {
        log.debug("Request to save MemoireDLC : {}", memoireDLCDTO);
        MemoireDLC memoireDLC = memoireDLCMapper.toEntity(memoireDLCDTO);
        memoireDLC = memoireDLCRepository.save(memoireDLC);
        return memoireDLCMapper.toDto(memoireDLC);
    }

    @Override
    public Optional<MemoireDLCDTO> partialUpdate(MemoireDLCDTO memoireDLCDTO) {
        log.debug("Request to partially update MemoireDLC : {}", memoireDLCDTO);

        return memoireDLCRepository
            .findById(memoireDLCDTO.getId())
            .map(existingMemoireDLC -> {
                memoireDLCMapper.partialUpdate(existingMemoireDLC, memoireDLCDTO);

                return existingMemoireDLC;
            })
            .map(memoireDLCRepository::save)
            .map(memoireDLCMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemoireDLCDTO> findAll() {
        log.debug("Request to get all MemoireDLCS");
        return memoireDLCRepository.findAll().stream().map(memoireDLCMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MemoireDLCDTO> findOne(Long id) {
        log.debug("Request to get MemoireDLC : {}", id);
        return memoireDLCRepository.findById(id).map(memoireDLCMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete MemoireDLC : {}", id);
        memoireDLCRepository.deleteById(id);
    }
}
