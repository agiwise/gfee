package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemoireMapperTest {

    private MemoireMapper memoireMapper;

    @BeforeEach
    public void setUp() {
        memoireMapper = new MemoireMapperImpl();
    }
}
