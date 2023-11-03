package ma.iam.wissal.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ma.iam.wissal.domain.UserDLC;
import ma.iam.wissal.repository.UserDLCRepository;
import ma.iam.wissal.service.UserDLCService;
import ma.iam.wissal.service.dto.UserDLCDTO;
import ma.iam.wissal.service.mapper.UserDLCMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link UserDLC}.
 */
@Service
@Transactional
public class UserDLCServiceImpl implements UserDLCService {

    private final Logger log = LoggerFactory.getLogger(UserDLCServiceImpl.class);

    private final UserDLCRepository userDLCRepository;

    private final UserDLCMapper userDLCMapper;

    public UserDLCServiceImpl(UserDLCRepository userDLCRepository, UserDLCMapper userDLCMapper) {
        this.userDLCRepository = userDLCRepository;
        this.userDLCMapper = userDLCMapper;
    }

    @Override
    public UserDLCDTO save(UserDLCDTO userDLCDTO) {
        log.debug("Request to save UserDLC : {}", userDLCDTO);
        UserDLC userDLC = userDLCMapper.toEntity(userDLCDTO);
        userDLC = userDLCRepository.save(userDLC);
        return userDLCMapper.toDto(userDLC);
    }

    @Override
    public Optional<UserDLCDTO> partialUpdate(UserDLCDTO userDLCDTO) {
        log.debug("Request to partially update UserDLC : {}", userDLCDTO);

        return userDLCRepository
            .findById(userDLCDTO.getId())
            .map(existingUserDLC -> {
                userDLCMapper.partialUpdate(existingUserDLC, userDLCDTO);

                return existingUserDLC;
            })
            .map(userDLCRepository::save)
            .map(userDLCMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDLCDTO> findAll() {
        log.debug("Request to get all UserDLCS");
        return userDLCRepository.findAll().stream().map(userDLCMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDLCDTO> findOne(Long id) {
        log.debug("Request to get UserDLC : {}", id);
        return userDLCRepository.findById(id).map(userDLCMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserDLC : {}", id);
        userDLCRepository.deleteById(id);
    }
}
