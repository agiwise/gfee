package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.IndexReel;
import ma.iam.wissal.repository.IndexReelRepository;
import ma.iam.wissal.service.IndexReelService;
import ma.iam.wissal.service.dto.IndexReelDTO;
import ma.iam.wissal.service.mapper.IndexReelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link IndexReel}.
 */
@Service
@Transactional
public class IndexReelServiceImpl implements IndexReelService {

    private final Logger log = LoggerFactory.getLogger(IndexReelServiceImpl.class);

    private final IndexReelRepository indexReelRepository;

    private final IndexReelMapper indexReelMapper;

    public IndexReelServiceImpl(IndexReelRepository indexReelRepository, IndexReelMapper indexReelMapper) {
        this.indexReelRepository = indexReelRepository;
        this.indexReelMapper = indexReelMapper;
    }

    @Override
    public IndexReelDTO save(IndexReelDTO indexReelDTO) {
        log.debug("Request to save IndexReel : {}", indexReelDTO);
        IndexReel indexReel = indexReelMapper.toEntity(indexReelDTO);
        indexReel = indexReelRepository.save(indexReel);
        return indexReelMapper.toDto(indexReel);
    }

    @Override
    public Optional<IndexReelDTO> partialUpdate(IndexReelDTO indexReelDTO) {
        log.debug("Request to partially update IndexReel : {}", indexReelDTO);

        return indexReelRepository
            .findById(indexReelDTO.getId())
            .map(existingIndexReel -> {
                indexReelMapper.partialUpdate(existingIndexReel, indexReelDTO);

                return existingIndexReel;
            })
            .map(indexReelRepository::save)
            .map(indexReelMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IndexReelDTO> findAll() {
        log.debug("Request to get all IndexReels");
        return indexReelRepository.findAll().stream().map(indexReelMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IndexReelDTO> findOne(Long id) {
        log.debug("Request to get IndexReel : {}", id);
        return indexReelRepository.findById(id).map(indexReelMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete IndexReel : {}", id);
        indexReelRepository.deleteById(id);
    }
}
