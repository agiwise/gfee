package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserDLCTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDLC.class);
        UserDLC userDLC1 = new UserDLC();
        userDLC1.setId(1L);
        UserDLC userDLC2 = new UserDLC();
        userDLC2.setId(userDLC1.getId());
        assertThat(userDLC1).isEqualTo(userDLC2);
        userDLC2.setId(2L);
        assertThat(userDLC1).isNotEqualTo(userDLC2);
        userDLC1.setId(null);
        assertThat(userDLC1).isNotEqualTo(userDLC2);
    }
}
