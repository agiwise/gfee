package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IocDLCMapperTest {

    private IocDLCMapper iocDLCMapper;

    @BeforeEach
    public void setUp() {
        iocDLCMapper = new IocDLCMapperImpl();
    }
}
