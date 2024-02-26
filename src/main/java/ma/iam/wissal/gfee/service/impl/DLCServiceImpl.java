package ma.iam.wissal.gfee.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.gfee.domain.DLC;
import ma.iam.wissal.gfee.repository.DLCRepository;
import ma.iam.wissal.gfee.service.DLCService;
import ma.iam.wissal.gfee.service.dto.DLCDTO;
import ma.iam.wissal.gfee.service.mapper.DLCMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link DLC}.
 */
@Service
@Transactional
public class DLCServiceImpl implements DLCService {

    private final Logger log = LoggerFactory.getLogger(DLCServiceImpl.class);

    private final DLCRepository dLCRepository;

    private final DLCMapper dLCMapper;

    public DLCServiceImpl(DLCRepository dLCRepository, DLCMapper dLCMapper) {
        this.dLCRepository = dLCRepository;
        this.dLCMapper = dLCMapper;
    }

    @Override
    public DLCDTO save(DLCDTO dLCDTO) {
        log.debug("Request to save DLC : {}", dLCDTO);
        DLC dLC = dLCMapper.toEntity(dLCDTO);
        dLC = dLCRepository.save(dLC);
        return dLCMapper.toDto(dLC);
    }

    @Override
    public Optional<DLCDTO> partialUpdate(DLCDTO dLCDTO) {
        log.debug("Request to partially update DLC : {}", dLCDTO);

        return dLCRepository
            .findById(dLCDTO.getId())
            .map(existingDLC -> {
                dLCMapper.partialUpdate(existingDLC, dLCDTO);

                return existingDLC;
            })
            .map(dLCRepository::save)
            .map(dLCMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DLCDTO> findAll() {
        log.debug("Request to get all DLCS");
        return dLCRepository.findAll().stream().map(dLCMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DLCDTO> findOne(Long id) {
        log.debug("Request to get DLC : {}", id);
        return dLCRepository.findById(id).map(dLCMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DLC : {}", id);
        dLCRepository.deleteById(id);
    }

	@Override
	public List<DLCDTO> findDlcsByDirection(Long idDirection) {
        log.debug("Request to find Dlcs By Direction : {}", idDirection);

		return dLCRepository.findDlcsByIdDirectionRegionale(idDirection);
	}
}
