package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.MemoireRepository;
import ma.iam.wissal.service.MemoireService;
import ma.iam.wissal.service.dto.MemoireDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.Memoire}.
 */
@RestController
@RequestMapping("/api")
public class MemoireResource {

    private final Logger log = LoggerFactory.getLogger(MemoireResource.class);

    private static final String ENTITY_NAME = "memoire";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MemoireService memoireService;

    private final MemoireRepository memoireRepository;

    public MemoireResource(MemoireService memoireService, MemoireRepository memoireRepository) {
        this.memoireService = memoireService;
        this.memoireRepository = memoireRepository;
    }

    /**
     * {@code POST  /memoires} : Create a new memoire.
     *
     * @param memoireDTO the memoireDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new memoireDTO, or with status {@code 400 (Bad Request)} if the memoire has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/memoires")
    public ResponseEntity<MemoireDTO> createMemoire(@RequestBody MemoireDTO memoireDTO) throws URISyntaxException {
        log.debug("REST request to save Memoire : {}", memoireDTO);
        if (memoireDTO.getId() != null) {
            throw new BadRequestAlertException("A new memoire cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MemoireDTO result = memoireService.save(memoireDTO);
        return ResponseEntity
            .created(new URI("/api/memoires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /memoires/:id} : Updates an existing memoire.
     *
     * @param id the id of the memoireDTO to save.
     * @param memoireDTO the memoireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated memoireDTO,
     * or with status {@code 400 (Bad Request)} if the memoireDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the memoireDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/memoires/{id}")
    public ResponseEntity<MemoireDTO> updateMemoire(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MemoireDTO memoireDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Memoire : {}, {}", id, memoireDTO);
        if (memoireDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, memoireDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!memoireRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        MemoireDTO result = memoireService.save(memoireDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, memoireDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /memoires/:id} : Partial updates given fields of an existing memoire, field will ignore if it is null
     *
     * @param id the id of the memoireDTO to save.
     * @param memoireDTO the memoireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated memoireDTO,
     * or with status {@code 400 (Bad Request)} if the memoireDTO is not valid,
     * or with status {@code 404 (Not Found)} if the memoireDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the memoireDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/memoires/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MemoireDTO> partialUpdateMemoire(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MemoireDTO memoireDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Memoire partially : {}, {}", id, memoireDTO);
        if (memoireDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, memoireDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!memoireRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MemoireDTO> result = memoireService.partialUpdate(memoireDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, memoireDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /memoires} : get all the memoires.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of memoires in body.
     */
    @GetMapping("/memoires")
    public List<MemoireDTO> getAllMemoires() {
        log.debug("REST request to get all Memoires");
        return memoireService.findAll();
    }

    /**
     * {@code GET  /memoires/:id} : get the "id" memoire.
     *
     * @param id the id of the memoireDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the memoireDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/memoires/{id}")
    public ResponseEntity<MemoireDTO> getMemoire(@PathVariable Long id) {
        log.debug("REST request to get Memoire : {}", id);
        Optional<MemoireDTO> memoireDTO = memoireService.findOne(id);
        return ResponseUtil.wrapOrNotFound(memoireDTO);
    }

    /**
     * {@code DELETE  /memoires/:id} : delete the "id" memoire.
     *
     * @param id the id of the memoireDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/memoires/{id}")
    public ResponseEntity<Void> deleteMemoire(@PathVariable Long id) {
        log.debug("REST request to delete Memoire : {}", id);
        memoireService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
