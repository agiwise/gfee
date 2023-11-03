package ma.iam.wissal.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MemoireDLCTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MemoireDLC.class);
        MemoireDLC memoireDLC1 = new MemoireDLC();
        memoireDLC1.setId(1L);
        MemoireDLC memoireDLC2 = new MemoireDLC();
        memoireDLC2.setId(memoireDLC1.getId());
        assertThat(memoireDLC1).isEqualTo(memoireDLC2);
        memoireDLC2.setId(2L);
        assertThat(memoireDLC1).isNotEqualTo(memoireDLC2);
        memoireDLC1.setId(null);
        assertThat(memoireDLC1).isNotEqualTo(memoireDLC2);
    }
}
