package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MemoireTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Memoire.class);
        Memoire memoire1 = new Memoire();
        memoire1.setId(1L);
        Memoire memoire2 = new Memoire();
        memoire2.setId(memoire1.getId());
        assertThat(memoire1).isEqualTo(memoire2);
        memoire2.setId(2L);
        assertThat(memoire1).isNotEqualTo(memoire2);
        memoire1.setId(null);
        assertThat(memoire1).isNotEqualTo(memoire2);
    }
}
