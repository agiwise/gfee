package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MemoireDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MemoireDTO.class);
        MemoireDTO memoireDTO1 = new MemoireDTO();
        memoireDTO1.setId(1L);
        MemoireDTO memoireDTO2 = new MemoireDTO();
        assertThat(memoireDTO1).isNotEqualTo(memoireDTO2);
        memoireDTO2.setId(memoireDTO1.getId());
        assertThat(memoireDTO1).isEqualTo(memoireDTO2);
        memoireDTO2.setId(2L);
        assertThat(memoireDTO1).isNotEqualTo(memoireDTO2);
        memoireDTO1.setId(null);
        assertThat(memoireDTO1).isNotEqualTo(memoireDTO2);
    }
}
