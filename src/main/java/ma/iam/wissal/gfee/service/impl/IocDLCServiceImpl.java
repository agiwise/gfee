package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.gfee.domain.IocDLC;
import ma.iam.wissal.gfee.repository.IocDLCRepository;
import ma.iam.wissal.gfee.service.IocDLCService;
import ma.iam.wissal.gfee.service.dto.IocDLCDTO;
import ma.iam.wissal.gfee.service.mapper.IocDLCMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link IocDLC}.
 */
@Service
@Transactional
public class IocDLCServiceImpl implements IocDLCService {

    private final Logger log = LoggerFactory.getLogger(IocDLCServiceImpl.class);

    private final IocDLCRepository iocDLCRepository;

    private final IocDLCMapper iocDLCMapper;

    public IocDLCServiceImpl(IocDLCRepository iocDLCRepository, IocDLCMapper iocDLCMapper) {
        this.iocDLCRepository = iocDLCRepository;
        this.iocDLCMapper = iocDLCMapper;
    }

    @Override
    public IocDLCDTO save(IocDLCDTO iocDLCDTO) {
        log.debug("Request to save IocDLC : {}", iocDLCDTO);
        IocDLC iocDLC = iocDLCMapper.toEntity(iocDLCDTO);
        iocDLC = iocDLCRepository.save(iocDLC);
        return iocDLCMapper.toDto(iocDLC);
    }

    @Override
    public Optional<IocDLCDTO> partialUpdate(IocDLCDTO iocDLCDTO) {
        log.debug("Request to partially update IocDLC : {}", iocDLCDTO);

        return iocDLCRepository
            .findById(iocDLCDTO.getId())
            .map(existingIocDLC -> {
                iocDLCMapper.partialUpdate(existingIocDLC, iocDLCDTO);

                return existingIocDLC;
            })
            .map(iocDLCRepository::save)
            .map(iocDLCMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IocDLCDTO> findAll() {
        log.debug("Request to get all IocDLCS");
        return iocDLCRepository.findAll().stream().map(iocDLCMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IocDLCDTO> findOne(Long id) {
        log.debug("Request to get IocDLC : {}", id);
        return iocDLCRepository.findById(id).map(iocDLCMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete IocDLC : {}", id);
        iocDLCRepository.deleteById(id);
    }
}
