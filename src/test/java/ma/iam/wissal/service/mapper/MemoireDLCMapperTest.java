package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemoireDLCMapperTest {

    private MemoireDLCMapper memoireDLCMapper;

    @BeforeEach
    public void setUp() {
        memoireDLCMapper = new MemoireDLCMapperImpl();
    }
}
