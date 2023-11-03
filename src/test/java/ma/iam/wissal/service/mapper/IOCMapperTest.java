package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOCMapperTest {

    private IOCMapper iOCMapper;

    @BeforeEach
    public void setUp() {
        iOCMapper = new IOCMapperImpl();
    }
}
