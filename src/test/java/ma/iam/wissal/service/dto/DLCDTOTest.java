package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DLCDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DLCDTO.class);
        DLCDTO dLCDTO1 = new DLCDTO();
        dLCDTO1.setId(1L);
        DLCDTO dLCDTO2 = new DLCDTO();
        assertThat(dLCDTO1).isNotEqualTo(dLCDTO2);
        dLCDTO2.setId(dLCDTO1.getId());
        assertThat(dLCDTO1).isEqualTo(dLCDTO2);
        dLCDTO2.setId(2L);
        assertThat(dLCDTO1).isNotEqualTo(dLCDTO2);
        dLCDTO1.setId(null);
        assertThat(dLCDTO1).isNotEqualTo(dLCDTO2);
    }
}
