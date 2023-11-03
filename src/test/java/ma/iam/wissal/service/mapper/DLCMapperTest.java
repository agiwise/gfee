package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DLCMapperTest {

    private DLCMapper dLCMapper;

    @BeforeEach
    public void setUp() {
        dLCMapper = new DLCMapperImpl();
    }
}
