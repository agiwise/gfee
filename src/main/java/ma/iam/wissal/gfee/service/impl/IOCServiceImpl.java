package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.gfee.domain.IOC;
import ma.iam.wissal.gfee.repository.IOCRepository;
import ma.iam.wissal.gfee.service.IOCService;
import ma.iam.wissal.gfee.service.dto.IOCDTO;
import ma.iam.wissal.gfee.service.mapper.IOCMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link IOC}.
 */
@Service
@Transactional
public class IOCServiceImpl implements IOCService {

    private final Logger log = LoggerFactory.getLogger(IOCServiceImpl.class);

    private final IOCRepository iOCRepository;

    private final IOCMapper iOCMapper;

    public IOCServiceImpl(IOCRepository iOCRepository, IOCMapper iOCMapper) {
        this.iOCRepository = iOCRepository;
        this.iOCMapper = iOCMapper;
    }

    @Override
    public IOCDTO save(IOCDTO iOCDTO) {
        log.debug("Request to save IOC : {}", iOCDTO);
        IOC iOC = iOCMapper.toEntity(iOCDTO);
        iOC = iOCRepository.save(iOC);
        return iOCMapper.toDto(iOC);
    }

    @Override
    public Optional<IOCDTO> partialUpdate(IOCDTO iOCDTO) {
        log.debug("Request to partially update IOC : {}", iOCDTO);

        return iOCRepository
            .findById(iOCDTO.getId())
            .map(existingIOC -> {
                iOCMapper.partialUpdate(existingIOC, iOCDTO);

                return existingIOC;
            })
            .map(iOCRepository::save)
            .map(iOCMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IOCDTO> findAll() {
        log.debug("Request to get all IOCS");
        return iOCRepository.findAll().stream().map(iOCMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IOCDTO> findOne(Long id) {
        log.debug("Request to get IOC : {}", id);
        return iOCRepository.findById(id).map(iOCMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete IOC : {}", id);
        iOCRepository.deleteById(id);
    }
}
