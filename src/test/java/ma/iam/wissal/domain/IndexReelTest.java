package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IndexReelTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IndexReel.class);
        IndexReel indexReel1 = new IndexReel();
        indexReel1.setId(1L);
        IndexReel indexReel2 = new IndexReel();
        indexReel2.setId(indexReel1.getId());
        assertThat(indexReel1).isEqualTo(indexReel2);
        indexReel2.setId(2L);
        assertThat(indexReel1).isNotEqualTo(indexReel2);
        indexReel1.setId(null);
        assertThat(indexReel1).isNotEqualTo(indexReel2);
    }
}
