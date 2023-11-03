package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.Fournisseur;
import ma.iam.wissal.repository.FournisseurRepository;
import ma.iam.wissal.service.FournisseurService;
import ma.iam.wissal.service.dto.FournisseurDTO;
import ma.iam.wissal.service.mapper.FournisseurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Fournisseur}.
 */
@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    private final Logger log = LoggerFactory.getLogger(FournisseurServiceImpl.class);

    private final FournisseurRepository fournisseurRepository;

    private final FournisseurMapper fournisseurMapper;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, FournisseurMapper fournisseurMapper) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurMapper = fournisseurMapper;
    }

    @Override
    public FournisseurDTO save(FournisseurDTO fournisseurDTO) {
        log.debug("Request to save Fournisseur : {}", fournisseurDTO);
        Fournisseur fournisseur = fournisseurMapper.toEntity(fournisseurDTO);
        fournisseur = fournisseurRepository.save(fournisseur);
        return fournisseurMapper.toDto(fournisseur);
    }

    @Override
    public Optional<FournisseurDTO> partialUpdate(FournisseurDTO fournisseurDTO) {
        log.debug("Request to partially update Fournisseur : {}", fournisseurDTO);

        return fournisseurRepository
            .findById(fournisseurDTO.getId())
            .map(existingFournisseur -> {
                fournisseurMapper.partialUpdate(existingFournisseur, fournisseurDTO);

                return existingFournisseur;
            })
            .map(fournisseurRepository::save)
            .map(fournisseurMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FournisseurDTO> findAll() {
        log.debug("Request to get all Fournisseurs");
        return fournisseurRepository.findAll().stream().map(fournisseurMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FournisseurDTO> findOne(Long id) {
        log.debug("Request to get Fournisseur : {}", id);
        return fournisseurRepository.findById(id).map(fournisseurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Fournisseur : {}", id);
        fournisseurRepository.deleteById(id);
    }
}
