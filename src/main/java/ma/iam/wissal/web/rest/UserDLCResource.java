package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.UserDLCRepository;
import ma.iam.wissal.service.UserDLCService;
import ma.iam.wissal.service.dto.UserDLCDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.UserDLC}.
 */
@RestController
@RequestMapping("/api")
public class UserDLCResource {

    private final Logger log = LoggerFactory.getLogger(UserDLCResource.class);

    private static final String ENTITY_NAME = "userDLC";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserDLCService userDLCService;

    private final UserDLCRepository userDLCRepository;

    public UserDLCResource(UserDLCService userDLCService, UserDLCRepository userDLCRepository) {
        this.userDLCService = userDLCService;
        this.userDLCRepository = userDLCRepository;
    }

    /**
     * {@code POST  /user-dlcs} : Create a new userDLC.
     *
     * @param userDLCDTO the userDLCDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userDLCDTO, or with status {@code 400 (Bad Request)} if the userDLC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-dlcs")
    public ResponseEntity<UserDLCDTO> createUserDLC(@RequestBody UserDLCDTO userDLCDTO) throws URISyntaxException {
        log.debug("REST request to save UserDLC : {}", userDLCDTO);
        if (userDLCDTO.getId() != null) {
            throw new BadRequestAlertException("A new userDLC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserDLCDTO result = userDLCService.save(userDLCDTO);
        return ResponseEntity
            .created(new URI("/api/user-dlcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-dlcs/:id} : Updates an existing userDLC.
     *
     * @param id the id of the userDLCDTO to save.
     * @param userDLCDTO the userDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userDLCDTO,
     * or with status {@code 400 (Bad Request)} if the userDLCDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-dlcs/{id}")
    public ResponseEntity<UserDLCDTO> updateUserDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody UserDLCDTO userDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to update UserDLC : {}, {}", id, userDLCDTO);
        if (userDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        UserDLCDTO result = userDLCService.save(userDLCDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userDLCDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /user-dlcs/:id} : Partial updates given fields of an existing userDLC, field will ignore if it is null
     *
     * @param id the id of the userDLCDTO to save.
     * @param userDLCDTO the userDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userDLCDTO,
     * or with status {@code 400 (Bad Request)} if the userDLCDTO is not valid,
     * or with status {@code 404 (Not Found)} if the userDLCDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the userDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/user-dlcs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<UserDLCDTO> partialUpdateUserDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody UserDLCDTO userDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update UserDLC partially : {}, {}", id, userDLCDTO);
        if (userDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<UserDLCDTO> result = userDLCService.partialUpdate(userDLCDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userDLCDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /user-dlcs} : get all the userDLCS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userDLCS in body.
     */
    @GetMapping("/user-dlcs")
    public List<UserDLCDTO> getAllUserDLCS() {
        log.debug("REST request to get all UserDLCS");
        return userDLCService.findAll();
    }

    /**
     * {@code GET  /user-dlcs/:id} : get the "id" userDLC.
     *
     * @param id the id of the userDLCDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userDLCDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-dlcs/{id}")
    public ResponseEntity<UserDLCDTO> getUserDLC(@PathVariable Long id) {
        log.debug("REST request to get UserDLC : {}", id);
        Optional<UserDLCDTO> userDLCDTO = userDLCService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userDLCDTO);
    }

    /**
     * {@code DELETE  /user-dlcs/:id} : delete the "id" userDLC.
     *
     * @param id the id of the userDLCDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-dlcs/{id}")
    public ResponseEntity<Void> deleteUserDLC(@PathVariable Long id) {
        log.debug("REST request to delete UserDLC : {}", id);
        userDLCService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
