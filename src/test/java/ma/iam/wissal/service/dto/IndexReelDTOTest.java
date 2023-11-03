package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IndexReelDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IndexReelDTO.class);
        IndexReelDTO indexReelDTO1 = new IndexReelDTO();
        indexReelDTO1.setId(1L);
        IndexReelDTO indexReelDTO2 = new IndexReelDTO();
        assertThat(indexReelDTO1).isNotEqualTo(indexReelDTO2);
        indexReelDTO2.setId(indexReelDTO1.getId());
        assertThat(indexReelDTO1).isEqualTo(indexReelDTO2);
        indexReelDTO2.setId(2L);
        assertThat(indexReelDTO1).isNotEqualTo(indexReelDTO2);
        indexReelDTO1.setId(null);
        assertThat(indexReelDTO1).isNotEqualTo(indexReelDTO2);
    }
}
