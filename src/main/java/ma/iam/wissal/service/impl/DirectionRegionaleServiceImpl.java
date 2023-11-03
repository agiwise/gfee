package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.DirectionRegionale;
import ma.iam.wissal.repository.DirectionRegionaleRepository;
import ma.iam.wissal.service.DirectionRegionaleService;
import ma.iam.wissal.service.dto.DirectionRegionaleDTO;
import ma.iam.wissal.service.mapper.DirectionRegionaleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link DirectionRegionale}.
 */
@Service
@Transactional
public class DirectionRegionaleServiceImpl implements DirectionRegionaleService {

    private final Logger log = LoggerFactory.getLogger(DirectionRegionaleServiceImpl.class);

    private final DirectionRegionaleRepository directionRegionaleRepository;

    private final DirectionRegionaleMapper directionRegionaleMapper;

    public DirectionRegionaleServiceImpl(
        DirectionRegionaleRepository directionRegionaleRepository,
        DirectionRegionaleMapper directionRegionaleMapper
    ) {
        this.directionRegionaleRepository = directionRegionaleRepository;
        this.directionRegionaleMapper = directionRegionaleMapper;
    }

    @Override
    public DirectionRegionaleDTO save(DirectionRegionaleDTO directionRegionaleDTO) {
        log.debug("Request to save DirectionRegionale : {}", directionRegionaleDTO);
        DirectionRegionale directionRegionale = directionRegionaleMapper.toEntity(directionRegionaleDTO);
        directionRegionale = directionRegionaleRepository.save(directionRegionale);
        return directionRegionaleMapper.toDto(directionRegionale);
    }

    @Override
    public Optional<DirectionRegionaleDTO> partialUpdate(DirectionRegionaleDTO directionRegionaleDTO) {
        log.debug("Request to partially update DirectionRegionale : {}", directionRegionaleDTO);

        return directionRegionaleRepository
            .findById(directionRegionaleDTO.getId())
            .map(existingDirectionRegionale -> {
                directionRegionaleMapper.partialUpdate(existingDirectionRegionale, directionRegionaleDTO);

                return existingDirectionRegionale;
            })
            .map(directionRegionaleRepository::save)
            .map(directionRegionaleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectionRegionaleDTO> findAll() {
        log.debug("Request to get all DirectionRegionales");
        return directionRegionaleRepository
            .findAll()
            .stream()
            .map(directionRegionaleMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DirectionRegionaleDTO> findOne(Long id) {
        log.debug("Request to get DirectionRegionale : {}", id);
        return directionRegionaleRepository.findById(id).map(directionRegionaleMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DirectionRegionale : {}", id);
        directionRegionaleRepository.deleteById(id);
    }
}
