package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.DLCRepository;
import ma.iam.wissal.service.DLCService;
import ma.iam.wissal.service.dto.DLCDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.DLC}.
 */
@RestController
@RequestMapping("/api")
public class DLCResource {

    private final Logger log = LoggerFactory.getLogger(DLCResource.class);

    private static final String ENTITY_NAME = "dLC";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DLCService dLCService;

    private final DLCRepository dLCRepository;

    public DLCResource(DLCService dLCService, DLCRepository dLCRepository) {
        this.dLCService = dLCService;
        this.dLCRepository = dLCRepository;
    }

    /**
     * {@code POST  /dlcs} : Create a new dLC.
     *
     * @param dLCDTO the dLCDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dLCDTO, or with status {@code 400 (Bad Request)} if the dLC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dlcs")
    public ResponseEntity<DLCDTO> createDLC(@RequestBody DLCDTO dLCDTO) throws URISyntaxException {
        log.debug("REST request to save DLC : {}", dLCDTO);
        if (dLCDTO.getId() != null) {
            throw new BadRequestAlertException("A new dLC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DLCDTO result = dLCService.save(dLCDTO);
        return ResponseEntity
            .created(new URI("/api/dlcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dlcs/:id} : Updates an existing dLC.
     *
     * @param id the id of the dLCDTO to save.
     * @param dLCDTO the dLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dLCDTO,
     * or with status {@code 400 (Bad Request)} if the dLCDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dlcs/{id}")
    public ResponseEntity<DLCDTO> updateDLC(@PathVariable(value = "id", required = false) final Long id, @RequestBody DLCDTO dLCDTO)
        throws URISyntaxException {
        log.debug("REST request to update DLC : {}, {}", id, dLCDTO);
        if (dLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DLCDTO result = dLCService.save(dLCDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dLCDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /dlcs/:id} : Partial updates given fields of an existing dLC, field will ignore if it is null
     *
     * @param id the id of the dLCDTO to save.
     * @param dLCDTO the dLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dLCDTO,
     * or with status {@code 400 (Bad Request)} if the dLCDTO is not valid,
     * or with status {@code 404 (Not Found)} if the dLCDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the dLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/dlcs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DLCDTO> partialUpdateDLC(@PathVariable(value = "id", required = false) final Long id, @RequestBody DLCDTO dLCDTO)
        throws URISyntaxException {
        log.debug("REST request to partial update DLC partially : {}, {}", id, dLCDTO);
        if (dLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, dLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!dLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DLCDTO> result = dLCService.partialUpdate(dLCDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dLCDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /dlcs} : get all the dLCS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dLCS in body.
     */
    @GetMapping("/dlcs")
    public List<DLCDTO> getAllDLCS() {
        log.debug("REST request to get all DLCS");
        return dLCService.findAll();
    }

    /**
     * {@code GET  /dlcs/:id} : get the "id" dLC.
     *
     * @param id the id of the dLCDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dLCDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dlcs/{id}")
    public ResponseEntity<DLCDTO> getDLC(@PathVariable Long id) {
        log.debug("REST request to get DLC : {}", id);
        Optional<DLCDTO> dLCDTO = dLCService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dLCDTO);
    }

    /**
     * {@code DELETE  /dlcs/:id} : delete the "id" dLC.
     *
     * @param id the id of the dLCDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dlcs/{id}")
    public ResponseEntity<Void> deleteDLC(@PathVariable Long id) {
        log.debug("REST request to delete DLC : {}", id);
        dLCService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
