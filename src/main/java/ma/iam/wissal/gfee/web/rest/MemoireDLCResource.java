package ma.iam.wissal.gfee.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.gfee.repository.MemoireDLCRepository;
import ma.iam.wissal.gfee.service.MemoireDLCService;
import ma.iam.wissal.gfee.service.dto.MemoireDLCDTO;
import ma.iam.wissal.gfee.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.gfee.domain.MemoireDLC}.
 */
@RestController
@RequestMapping("/api")
public class MemoireDLCResource {

    private final Logger log = LoggerFactory.getLogger(MemoireDLCResource.class);

    private static final String ENTITY_NAME = "memoireDLC";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MemoireDLCService memoireDLCService;

    private final MemoireDLCRepository memoireDLCRepository;

    public MemoireDLCResource(MemoireDLCService memoireDLCService, MemoireDLCRepository memoireDLCRepository) {
        this.memoireDLCService = memoireDLCService;
        this.memoireDLCRepository = memoireDLCRepository;
    }

    /**
     * {@code POST  /memoire-dlcs} : Create a new memoireDLC.
     *
     * @param memoireDLCDTO the memoireDLCDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new memoireDLCDTO, or with status {@code 400 (Bad Request)} if the memoireDLC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/memoire-dlcs")
    public ResponseEntity<MemoireDLCDTO> createMemoireDLC(@RequestBody MemoireDLCDTO memoireDLCDTO) throws URISyntaxException {
        log.debug("REST request to save MemoireDLC : {}", memoireDLCDTO);
        if (memoireDLCDTO.getId() != null) {
            throw new BadRequestAlertException("A new memoireDLC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MemoireDLCDTO result = memoireDLCService.save(memoireDLCDTO);
        return ResponseEntity
            .created(new URI("/api/memoire-dlcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /memoire-dlcs/:id} : Updates an existing memoireDLC.
     *
     * @param id the id of the memoireDLCDTO to save.
     * @param memoireDLCDTO the memoireDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated memoireDLCDTO,
     * or with status {@code 400 (Bad Request)} if the memoireDLCDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the memoireDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/memoire-dlcs/{id}")
    public ResponseEntity<MemoireDLCDTO> updateMemoireDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MemoireDLCDTO memoireDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to update MemoireDLC : {}, {}", id, memoireDLCDTO);
        if (memoireDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, memoireDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!memoireDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        MemoireDLCDTO result = memoireDLCService.save(memoireDLCDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, memoireDLCDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /memoire-dlcs/:id} : Partial updates given fields of an existing memoireDLC, field will ignore if it is null
     *
     * @param id the id of the memoireDLCDTO to save.
     * @param memoireDLCDTO the memoireDLCDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated memoireDLCDTO,
     * or with status {@code 400 (Bad Request)} if the memoireDLCDTO is not valid,
     * or with status {@code 404 (Not Found)} if the memoireDLCDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the memoireDLCDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/memoire-dlcs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MemoireDLCDTO> partialUpdateMemoireDLC(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody MemoireDLCDTO memoireDLCDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update MemoireDLC partially : {}, {}", id, memoireDLCDTO);
        if (memoireDLCDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, memoireDLCDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!memoireDLCRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MemoireDLCDTO> result = memoireDLCService.partialUpdate(memoireDLCDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, memoireDLCDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /memoire-dlcs} : get all the memoireDLCS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of memoireDLCS in body.
     */
    @GetMapping("/memoire-dlcs")
    public List<MemoireDLCDTO> getAllMemoireDLCS() {
        log.debug("REST request to get all MemoireDLCS");
        return memoireDLCService.findAll();
    }

    /**
     * {@code GET  /memoire-dlcs/:id} : get the "id" memoireDLC.
     *
     * @param id the id of the memoireDLCDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the memoireDLCDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/memoire-dlcs/{id}")
    public ResponseEntity<MemoireDLCDTO> getMemoireDLC(@PathVariable Long id) {
        log.debug("REST request to get MemoireDLC : {}", id);
        Optional<MemoireDLCDTO> memoireDLCDTO = memoireDLCService.findOne(id);
        return ResponseUtil.wrapOrNotFound(memoireDLCDTO);
    }

    /**
     * {@code DELETE  /memoire-dlcs/:id} : delete the "id" memoireDLC.
     *
     * @param id the id of the memoireDLCDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/memoire-dlcs/{id}")
    public ResponseEntity<Void> deleteMemoireDLC(@PathVariable Long id) {
        log.debug("REST request to delete MemoireDLC : {}", id);
        memoireDLCService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
