package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IocDLCTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IocDLC.class);
        IocDLC iocDLC1 = new IocDLC();
        iocDLC1.setId(1L);
        IocDLC iocDLC2 = new IocDLC();
        iocDLC2.setId(iocDLC1.getId());
        assertThat(iocDLC1).isEqualTo(iocDLC2);
        iocDLC2.setId(2L);
        assertThat(iocDLC1).isNotEqualTo(iocDLC2);
        iocDLC1.setId(null);
        assertThat(iocDLC1).isNotEqualTo(iocDLC2);
    }
}
