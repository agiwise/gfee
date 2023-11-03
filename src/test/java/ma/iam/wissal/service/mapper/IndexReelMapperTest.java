package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndexReelMapperTest {

    private IndexReelMapper indexReelMapper;

    @BeforeEach
    public void setUp() {
        indexReelMapper = new IndexReelMapperImpl();
    }
}
