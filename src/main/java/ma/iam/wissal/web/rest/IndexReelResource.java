package ma.iam.wissal.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ma.iam.wissal.repository.IndexReelRepository;
import ma.iam.wissal.service.IndexReelService;
import ma.iam.wissal.service.dto.IndexReelDTO;
import ma.iam.wissal.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.iam.wissal.domain.IndexReel}.
 */
@RestController
@RequestMapping("/api")
public class IndexReelResource {

    private final Logger log = LoggerFactory.getLogger(IndexReelResource.class);

    private static final String ENTITY_NAME = "indexReel";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IndexReelService indexReelService;

    private final IndexReelRepository indexReelRepository;

    public IndexReelResource(IndexReelService indexReelService, IndexReelRepository indexReelRepository) {
        this.indexReelService = indexReelService;
        this.indexReelRepository = indexReelRepository;
    }

    /**
     * {@code POST  /index-reels} : Create a new indexReel.
     *
     * @param indexReelDTO the indexReelDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new indexReelDTO, or with status {@code 400 (Bad Request)} if the indexReel has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/index-reels")
    public ResponseEntity<IndexReelDTO> createIndexReel(@RequestBody IndexReelDTO indexReelDTO) throws URISyntaxException {
        log.debug("REST request to save IndexReel : {}", indexReelDTO);
        if (indexReelDTO.getId() != null) {
            throw new BadRequestAlertException("A new indexReel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IndexReelDTO result = indexReelService.save(indexReelDTO);
        return ResponseEntity
            .created(new URI("/api/index-reels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /index-reels/:id} : Updates an existing indexReel.
     *
     * @param id the id of the indexReelDTO to save.
     * @param indexReelDTO the indexReelDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated indexReelDTO,
     * or with status {@code 400 (Bad Request)} if the indexReelDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the indexReelDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/index-reels/{id}")
    public ResponseEntity<IndexReelDTO> updateIndexReel(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody IndexReelDTO indexReelDTO
    ) throws URISyntaxException {
        log.debug("REST request to update IndexReel : {}, {}", id, indexReelDTO);
        if (indexReelDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, indexReelDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!indexReelRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        IndexReelDTO result = indexReelService.save(indexReelDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, indexReelDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /index-reels/:id} : Partial updates given fields of an existing indexReel, field will ignore if it is null
     *
     * @param id the id of the indexReelDTO to save.
     * @param indexReelDTO the indexReelDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated indexReelDTO,
     * or with status {@code 400 (Bad Request)} if the indexReelDTO is not valid,
     * or with status {@code 404 (Not Found)} if the indexReelDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the indexReelDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/index-reels/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<IndexReelDTO> partialUpdateIndexReel(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody IndexReelDTO indexReelDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update IndexReel partially : {}, {}", id, indexReelDTO);
        if (indexReelDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, indexReelDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!indexReelRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<IndexReelDTO> result = indexReelService.partialUpdate(indexReelDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, indexReelDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /index-reels} : get all the indexReels.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of indexReels in body.
     */
    @GetMapping("/index-reels")
    public List<IndexReelDTO> getAllIndexReels() {
        log.debug("REST request to get all IndexReels");
        return indexReelService.findAll();
    }

    /**
     * {@code GET  /index-reels/:id} : get the "id" indexReel.
     *
     * @param id the id of the indexReelDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the indexReelDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/index-reels/{id}")
    public ResponseEntity<IndexReelDTO> getIndexReel(@PathVariable Long id) {
        log.debug("REST request to get IndexReel : {}", id);
        Optional<IndexReelDTO> indexReelDTO = indexReelService.findOne(id);
        return ResponseUtil.wrapOrNotFound(indexReelDTO);
    }

    /**
     * {@code DELETE  /index-reels/:id} : delete the "id" indexReel.
     *
     * @param id the id of the indexReelDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/index-reels/{id}")
    public ResponseEntity<Void> deleteIndexReel(@PathVariable Long id) {
        log.debug("REST request to delete IndexReel : {}", id);
        indexReelService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
