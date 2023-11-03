package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.PIECESAP;
import ma.iam.wissal.repository.PIECESAPRepository;
import ma.iam.wissal.service.PIECESAPService;
import ma.iam.wissal.service.dto.PIECESAPDTO;
import ma.iam.wissal.service.mapper.PIECESAPMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PIECESAP}.
 */
@Service
@Transactional
public class PIECESAPServiceImpl implements PIECESAPService {

    private final Logger log = LoggerFactory.getLogger(PIECESAPServiceImpl.class);

    private final PIECESAPRepository pIECESAPRepository;

    private final PIECESAPMapper pIECESAPMapper;

    public PIECESAPServiceImpl(PIECESAPRepository pIECESAPRepository, PIECESAPMapper pIECESAPMapper) {
        this.pIECESAPRepository = pIECESAPRepository;
        this.pIECESAPMapper = pIECESAPMapper;
    }

    @Override
    public PIECESAPDTO save(PIECESAPDTO pIECESAPDTO) {
        log.debug("Request to save PIECESAP : {}", pIECESAPDTO);
        PIECESAP pIECESAP = pIECESAPMapper.toEntity(pIECESAPDTO);
        pIECESAP = pIECESAPRepository.save(pIECESAP);
        return pIECESAPMapper.toDto(pIECESAP);
    }

    @Override
    public Optional<PIECESAPDTO> partialUpdate(PIECESAPDTO pIECESAPDTO) {
        log.debug("Request to partially update PIECESAP : {}", pIECESAPDTO);

        return pIECESAPRepository
            .findById(pIECESAPDTO.getId())
            .map(existingPIECESAP -> {
                pIECESAPMapper.partialUpdate(existingPIECESAP, pIECESAPDTO);

                return existingPIECESAP;
            })
            .map(pIECESAPRepository::save)
            .map(pIECESAPMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PIECESAPDTO> findAll() {
        log.debug("Request to get all PIECESAPS");
        return pIECESAPRepository.findAll().stream().map(pIECESAPMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PIECESAPDTO> findOne(Long id) {
        log.debug("Request to get PIECESAP : {}", id);
        return pIECESAPRepository.findById(id).map(pIECESAPMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PIECESAP : {}", id);
        pIECESAPRepository.deleteById(id);
    }
}
