package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserDLCDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDLCDTO.class);
        UserDLCDTO userDLCDTO1 = new UserDLCDTO();
        userDLCDTO1.setId(1L);
        UserDLCDTO userDLCDTO2 = new UserDLCDTO();
        assertThat(userDLCDTO1).isNotEqualTo(userDLCDTO2);
        userDLCDTO2.setId(userDLCDTO1.getId());
        assertThat(userDLCDTO1).isEqualTo(userDLCDTO2);
        userDLCDTO2.setId(2L);
        assertThat(userDLCDTO1).isNotEqualTo(userDLCDTO2);
        userDLCDTO1.setId(null);
        assertThat(userDLCDTO1).isNotEqualTo(userDLCDTO2);
    }
}
