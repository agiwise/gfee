package ma.iam.wissal.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PIECESAPMapperTest {

    private PIECESAPMapper pIECESAPMapper;

    @BeforeEach
    public void setUp() {
        pIECESAPMapper = new PIECESAPMapperImpl();
    }
}
