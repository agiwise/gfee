package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PIECESAPDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PIECESAPDTO.class);
        PIECESAPDTO pIECESAPDTO1 = new PIECESAPDTO();
        pIECESAPDTO1.setId(1L);
        PIECESAPDTO pIECESAPDTO2 = new PIECESAPDTO();
        assertThat(pIECESAPDTO1).isNotEqualTo(pIECESAPDTO2);
        pIECESAPDTO2.setId(pIECESAPDTO1.getId());
        assertThat(pIECESAPDTO1).isEqualTo(pIECESAPDTO2);
        pIECESAPDTO2.setId(2L);
        assertThat(pIECESAPDTO1).isNotEqualTo(pIECESAPDTO2);
        pIECESAPDTO1.setId(null);
        assertThat(pIECESAPDTO1).isNotEqualTo(pIECESAPDTO2);
    }
}
