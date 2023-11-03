package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IOCDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IOCDTO.class);
        IOCDTO iOCDTO1 = new IOCDTO();
        iOCDTO1.setId(1L);
        IOCDTO iOCDTO2 = new IOCDTO();
        assertThat(iOCDTO1).isNotEqualTo(iOCDTO2);
        iOCDTO2.setId(iOCDTO1.getId());
        assertThat(iOCDTO1).isEqualTo(iOCDTO2);
        iOCDTO2.setId(2L);
        assertThat(iOCDTO1).isNotEqualTo(iOCDTO2);
        iOCDTO1.setId(null);
        assertThat(iOCDTO1).isNotEqualTo(iOCDTO2);
    }
}
