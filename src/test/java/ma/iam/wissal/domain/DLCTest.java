package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DLCTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DLC.class);
        DLC dLC1 = new DLC();
        dLC1.setId(1L);
        DLC dLC2 = new DLC();
        dLC2.setId(dLC1.getId());
        assertThat(dLC1).isEqualTo(dLC2);
        dLC2.setId(2L);
        assertThat(dLC1).isNotEqualTo(dLC2);
        dLC1.setId(null);
        assertThat(dLC1).isNotEqualTo(dLC2);
    }
}
