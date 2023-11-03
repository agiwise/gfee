package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MemoireDLCDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MemoireDLCDTO.class);
        MemoireDLCDTO memoireDLCDTO1 = new MemoireDLCDTO();
        memoireDLCDTO1.setId(1L);
        MemoireDLCDTO memoireDLCDTO2 = new MemoireDLCDTO();
        assertThat(memoireDLCDTO1).isNotEqualTo(memoireDLCDTO2);
        memoireDLCDTO2.setId(memoireDLCDTO1.getId());
        assertThat(memoireDLCDTO1).isEqualTo(memoireDLCDTO2);
        memoireDLCDTO2.setId(2L);
        assertThat(memoireDLCDTO1).isNotEqualTo(memoireDLCDTO2);
        memoireDLCDTO1.setId(null);
        assertThat(memoireDLCDTO1).isNotEqualTo(memoireDLCDTO2);
    }
}
