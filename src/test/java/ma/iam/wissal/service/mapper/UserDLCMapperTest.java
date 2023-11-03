package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDLCMapperTest {

    private UserDLCMapper userDLCMapper;

    @BeforeEach
    public void setUp() {
        userDLCMapper = new UserDLCMapperImpl();
    }
}
