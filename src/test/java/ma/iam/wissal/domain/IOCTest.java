package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IOCTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IOC.class);
        IOC iOC1 = new IOC();
        iOC1.setId(1L);
        IOC iOC2 = new IOC();
        iOC2.setId(iOC1.getId());
        assertThat(iOC1).isEqualTo(iOC2);
        iOC2.setId(2L);
        assertThat(iOC1).isNotEqualTo(iOC2);
        iOC1.setId(null);
        assertThat(iOC1).isNotEqualTo(iOC2);
    }
}
