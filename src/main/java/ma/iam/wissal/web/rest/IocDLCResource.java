package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.IocDLCRepository;
import ma.iam.wissal.service.IocDLCService;
import ma.iam.wissal.service.dto.IocDLCDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.IocDLC}.
 */
@RestController
@RequestMapping("/api")
public class IocDLCResource {

    private final Logger log = LoggerFactory.getLogger(IocDLCResource.class);

    private static final String ENTITY_NAME = "iocDLC";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IocDLCService iocDLCService;

    private final IocDLCRepository iocDLCRepository;

    public IocDLCResource(IocDLCService iocDLCService, IocDLCRepository iocDLCRepository) {
        this.iocDLCService = iocDLCService;
        this.iocDLCRepository = iocDLCRepository;
    }

    /**
     * {@code POST  /ioc-dlcs} : Create a new iocDLC.
     *
     * @param iocDLCDTO the iocDLCDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iocDLCDTO, or with status {@code 400 (Bad Request)} if the iocDLC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ioc-dlcs")
    public ResponseEntity<IocDLCDTO> createIocDLC(@RequestBody IocDLCDTO iocDLCDTO) throws URISyntaxException {
        log.debug("REST request to save IocDLC : {}", iocDLCDTO);
        if (iocDLCDTO.getId() != null) {
            throw new BadRequestAlertException("A new iocDLC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IocDLCDTO result = iocDLCService.save(iocDLCDTO);
        return ResponseEntity
            .created(new URI("/api/ioc-dlcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ioc-dlcs/:id} : Updates an existing iocDLC.
     *
     * @param id the id of the iocDLCDTO to save.
     * @param iocDLCDTO the iocDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iocDLCDTO,
     * or with status {@code 400 (Bad Request)} if the iocDLCDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iocDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ioc-dlcs/{id}")
    public ResponseEntity<IocDLCDTO> updateIocDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody IocDLCDTO iocDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to update IocDLC : {}, {}", id, iocDLCDTO);
        if (iocDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, iocDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!iocDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        IocDLCDTO result = iocDLCService.save(iocDLCDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, iocDLCDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /ioc-dlcs/:id} : Partial updates given fields of an existing iocDLC, field will ignore if it is null
     *
     * @param id the id of the iocDLCDTO to save.
     * @param iocDLCDTO the iocDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iocDLCDTO,
     * or with status {@code 400 (Bad Request)} if the iocDLCDTO is not valid,
     * or with status {@code 404 (Not Found)} if the iocDLCDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the iocDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/ioc-dlcs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<IocDLCDTO> partialUpdateIocDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody IocDLCDTO iocDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update IocDLC partially : {}, {}", id, iocDLCDTO);
        if (iocDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, iocDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!iocDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<IocDLCDTO> result = iocDLCService.partialUpdate(iocDLCDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, iocDLCDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /ioc-dlcs} : get all the iocDLCS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iocDLCS in body.
     */
    @GetMapping("/ioc-dlcs")
    public List<IocDLCDTO> getAllIocDLCS() {
        log.debug("REST request to get all IocDLCS");
        return iocDLCService.findAll();
    }

    /**
     * {@code GET  /ioc-dlcs/:id} : get the "id" iocDLC.
     *
     * @param id the id of the iocDLCDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iocDLCDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ioc-dlcs/{id}")
    public ResponseEntity<IocDLCDTO> getIocDLC(@PathVariable Long id) {
        log.debug("REST request to get IocDLC : {}", id);
        Optional<IocDLCDTO> iocDLCDTO = iocDLCService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iocDLCDTO);
    }

    /**
     * {@code DELETE  /ioc-dlcs/:id} : delete the "id" iocDLC.
     *
     * @param id the id of the iocDLCDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ioc-dlcs/{id}")
    public ResponseEntity<Void> deleteIocDLC(@PathVariable Long id) {
        log.debug("REST request to delete IocDLC : {}", id);
        iocDLCService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
