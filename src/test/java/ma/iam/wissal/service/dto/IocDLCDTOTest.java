package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class IocDLCDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IocDLCDTO.class);
        IocDLCDTO iocDLCDTO1 = new IocDLCDTO();
        iocDLCDTO1.setId(1L);
        IocDLCDTO iocDLCDTO2 = new IocDLCDTO();
        assertThat(iocDLCDTO1).isNotEqualTo(iocDLCDTO2);
        iocDLCDTO2.setId(iocDLCDTO1.getId());
        assertThat(iocDLCDTO1).isEqualTo(iocDLCDTO2);
        iocDLCDTO2.setId(2L);
        assertThat(iocDLCDTO1).isNotEqualTo(iocDLCDTO2);
        iocDLCDTO1.setId(null);
        assertThat(iocDLCDTO1).isNotEqualTo(iocDLCDTO2);
    }
}
