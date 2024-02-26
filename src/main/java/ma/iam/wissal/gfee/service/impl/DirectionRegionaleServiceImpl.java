package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ma.iam.wissal.gfee.business.DirectionRegionaleLocalService;
import ma.iam.wissal.gfee.domain.DirectionRegionale;
import ma.iam.wissal.gfee.repository.DirectionRegionaleRepository;
import ma.iam.wissal.gfee.service.DirectionRegionaleService;
import ma.iam.wissal.gfee.service.dto.DirectionRegionaleDTO;
import ma.iam.wissal.gfee.service.mapper.DirectionRegionaleMapper;
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
    
    private final DirectionRegionaleLocalService directionRegionaleLocalService;

    public DirectionRegionaleServiceImpl(
        DirectionRegionaleRepository directionRegionaleRepository,
        DirectionRegionaleMapper directionRegionaleMapper,
        DirectionRegionaleLocalService directionRegionaleLocalService
    ) {
        this.directionRegionaleRepository = directionRegionaleRepository;
        this.directionRegionaleMapper = directionRegionaleMapper;
        this.directionRegionaleLocalService = directionRegionaleLocalService;
    }

    @Override
    public DirectionRegionaleDTO save(DirectionRegionaleDTO directionRegionaleDTO) {
        log.debug("Request to save DirectionRegionale : {}", directionRegionaleDTO);
        DirectionRegionale directionRegionale = directionRegionaleMapper.toEntity(directionRegionaleDTO);
        directionRegionale = directionRegionaleLocalService.addDirectionRegionale(directionRegionale);
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
        return directionRegionaleLocalService
            .getDirectionRegionales()
            .stream()
            .map(directionRegionaleMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }
    
    @Override
    @Transactional(readOnly = true)
    public DirectionRegionaleDTO findOne(Long id) throws RuntimeException, Exception {
        log.debug("Request to get DirectionRegionale : {}", id);
        DirectionRegionale directionRegionale = directionRegionaleLocalService.getDirectionRegionale(id);
        if (directionRegionale != null) {
            return directionRegionaleMapper.toDto(directionRegionale);
        } else {
            return null;
        }
    }


    @Override
    public void delete(Long id) throws RuntimeException, Exception {
        log.debug("Request to delete DirectionRegionale : {}", id);
        directionRegionaleLocalService.deleteDirectionRegionale(id);
    }
}
