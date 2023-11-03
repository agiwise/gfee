package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PIECESAPTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PIECESAP.class);
        PIECESAP pIECESAP1 = new PIECESAP();
        pIECESAP1.setId(1L);
        PIECESAP pIECESAP2 = new PIECESAP();
        pIECESAP2.setId(pIECESAP1.getId());
        assertThat(pIECESAP1).isEqualTo(pIECESAP2);
        pIECESAP2.setId(2L);
        assertThat(pIECESAP1).isNotEqualTo(pIECESAP2);
        pIECESAP1.setId(null);
        assertThat(pIECESAP1).isNotEqualTo(pIECESAP2);
    }
}
