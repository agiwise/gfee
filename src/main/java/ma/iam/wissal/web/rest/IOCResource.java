package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.IOCRepository;
import ma.iam.wissal.service.IOCService;
import ma.iam.wissal.service.dto.IOCDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.IOC}.
 */
@RestController
@RequestMapping("/api")
public class IOCResource {

    private final Logger log = LoggerFactory.getLogger(IOCResource.class);

    private static final String ENTITY_NAME = "iOC";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IOCService iOCService;

    private final IOCRepository iOCRepository;

    public IOCResource(IOCService iOCService, IOCRepository iOCRepository) {
        this.iOCService = iOCService;
        this.iOCRepository = iOCRepository;
    }

    /**
     * {@code POST  /iocs} : Create a new iOC.
     *
     * @param iOCDTO the iOCDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iOCDTO, or with status {@code 400 (Bad Request)} if the iOC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/iocs")
    public ResponseEntity<IOCDTO> createIOC(@RequestBody IOCDTO iOCDTO) throws URISyntaxException {
        log.debug("REST request to save IOC : {}", iOCDTO);
        if (iOCDTO.getId() != null) {
            throw new BadRequestAlertException("A new iOC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IOCDTO result = iOCService.save(iOCDTO);
        return ResponseEntity
            .created(new URI("/api/iocs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /iocs/:id} : Updates an existing iOC.
     *
     * @param id the id of the iOCDTO to save.
     * @param iOCDTO the iOCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iOCDTO,
     * or with status {@code 400 (Bad Request)} if the iOCDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iOCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/iocs/{id}")
    public ResponseEntity<IOCDTO> updateIOC(@PathVariable(value = "id", required = false) final Long id, @RequestBody IOCDTO iOCDTO)
        throws URISyntaxException {
        log.debug("REST request to update IOC : {}, {}", id, iOCDTO);
        if (iOCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, iOCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!iOCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        IOCDTO result = iOCService.save(iOCDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, iOCDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /iocs/:id} : Partial updates given fields of an existing iOC, field will ignore if it is null
     *
     * @param id the id of the iOCDTO to save.
     * @param iOCDTO the iOCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iOCDTO,
     * or with status {@code 400 (Bad Request)} if the iOCDTO is not valid,
     * or with status {@code 404 (Not Found)} if the iOCDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the iOCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/iocs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<IOCDTO> partialUpdateIOC(@PathVariable(value = "id", required = false) final Long id, @RequestBody IOCDTO iOCDTO)
        throws URISyntaxException {
        log.debug("REST request to partial update IOC partially : {}, {}", id, iOCDTO);
        if (iOCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, iOCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!iOCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<IOCDTO> result = iOCService.partialUpdate(iOCDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, iOCDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /iocs} : get all the iOCS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iOCS in body.
     */
    @GetMapping("/iocs")
    public List<IOCDTO> getAllIOCS() {
        log.debug("REST request to get all IOCS");
        return iOCService.findAll();
    }

    /**
     * {@code GET  /iocs/:id} : get the "id" iOC.
     *
     * @param id the id of the iOCDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iOCDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/iocs/{id}")
    public ResponseEntity<IOCDTO> getIOC(@PathVariable Long id) {
        log.debug("REST request to get IOC : {}", id);
        Optional<IOCDTO> iOCDTO = iOCService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iOCDTO);
    }

    /**
     * {@code DELETE  /iocs/:id} : delete the "id" iOC.
     *
     * @param id the id of the iOCDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/iocs/{id}")
    public ResponseEntity<Void> deleteIOC(@PathVariable Long id) {
        log.debug("REST request to delete IOC : {}", id);
        iOCService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
