package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.PIECESAPRepository;
import ma.iam.wissal.service.PIECESAPService;
import ma.iam.wissal.service.dto.PIECESAPDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.PIECESAP}.
 */
@RestController
@RequestMapping("/api")
public class PIECESAPResource {

    private final Logger log = LoggerFactory.getLogger(PIECESAPResource.class);

    private static final String ENTITY_NAME = "pIECESAP";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PIECESAPService pIECESAPService;

    private final PIECESAPRepository pIECESAPRepository;

    public PIECESAPResource(PIECESAPService pIECESAPService, PIECESAPRepository pIECESAPRepository) {
        this.pIECESAPService = pIECESAPService;
        this.pIECESAPRepository = pIECESAPRepository;
    }

    /**
     * {@code POST  /piecesaps} : Create a new pIECESAP.
     *
     * @param pIECESAPDTO the pIECESAPDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pIECESAPDTO, or with status {@code 400 (Bad Request)} if the pIECESAP has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/piecesaps")
    public ResponseEntity<PIECESAPDTO> createPIECESAP(@RequestBody PIECESAPDTO pIECESAPDTO) throws URISyntaxException {
        log.debug("REST request to save PIECESAP : {}", pIECESAPDTO);
        if (pIECESAPDTO.getId() != null) {
            throw new BadRequestAlertException("A new pIECESAP cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PIECESAPDTO result = pIECESAPService.save(pIECESAPDTO);
        return ResponseEntity
            .created(new URI("/api/piecesaps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /piecesaps/:id} : Updates an existing pIECESAP.
     *
     * @param id the id of the pIECESAPDTO to save.
     * @param pIECESAPDTO the pIECESAPDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pIECESAPDTO,
     * or with status {@code 400 (Bad Request)} if the pIECESAPDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pIECESAPDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/piecesaps/{id}")
    public ResponseEntity<PIECESAPDTO> updatePIECESAP(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody PIECESAPDTO pIECESAPDTO
    ) throws URISyntaxException {
        log.debug("REST request to update PIECESAP : {}, {}", id, pIECESAPDTO);
        if (pIECESAPDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pIECESAPDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pIECESAPRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        PIECESAPDTO result = pIECESAPService.save(pIECESAPDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pIECESAPDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /piecesaps/:id} : Partial updates given fields of an existing pIECESAP, field will ignore if it is null
     *
     * @param id the id of the pIECESAPDTO to save.
     * @param pIECESAPDTO the pIECESAPDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pIECESAPDTO,
     * or with status {@code 400 (Bad Request)} if the pIECESAPDTO is not valid,
     * or with status {@code 404 (Not Found)} if the pIECESAPDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the pIECESAPDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/piecesaps/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PIECESAPDTO> partialUpdatePIECESAP(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody PIECESAPDTO pIECESAPDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update PIECESAP partially : {}, {}", id, pIECESAPDTO);
        if (pIECESAPDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pIECESAPDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pIECESAPRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PIECESAPDTO> result = pIECESAPService.partialUpdate(pIECESAPDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pIECESAPDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /piecesaps} : get all the pIECESAPS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pIECESAPS in body.
     */
    @GetMapping("/piecesaps")
    public List<PIECESAPDTO> getAllPIECESAPS() {
        log.debug("REST request to get all PIECESAPS");
        return pIECESAPService.findAll();
    }

    /**
     * {@code GET  /piecesaps/:id} : get the "id" pIECESAP.
     *
     * @param id the id of the pIECESAPDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pIECESAPDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/piecesaps/{id}")
    public ResponseEntity<PIECESAPDTO> getPIECESAP(@PathVariable Long id) {
        log.debug("REST request to get PIECESAP : {}", id);
        Optional<PIECESAPDTO> pIECESAPDTO = pIECESAPService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pIECESAPDTO);
    }

    /**
     * {@code DELETE  /piecesaps/:id} : delete the "id" pIECESAP.
     *
     * @param id the id of the pIECESAPDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/piecesaps/{id}")
    public ResponseEntity<Void> deletePIECESAP(@PathVariable Long id) {
        log.debug("REST request to delete PIECESAP : {}", id);
        pIECESAPService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
