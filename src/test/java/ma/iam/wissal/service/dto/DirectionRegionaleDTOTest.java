package ma.iam.wissal.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import ma.iam.wissal.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DirectionRegionaleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DirectionRegionaleDTO.class);
        DirectionRegionaleDTO directionRegionaleDTO1 = new DirectionRegionaleDTO();
        directionRegionaleDTO1.setId(1L);
        DirectionRegionaleDTO directionRegionaleDTO2 = new DirectionRegionaleDTO();
        assertThat(directionRegionaleDTO1).isNotEqualTo(directionRegionaleDTO2);
        directionRegionaleDTO2.setId(directionRegionaleDTO1.getId());
        assertThat(directionRegionaleDTO1).isEqualTo(directionRegionaleDTO2);
        directionRegionaleDTO2.setId(2L);
        assertThat(directionRegionaleDTO1).isNotEqualTo(directionRegionaleDTO2);
        directionRegionaleDTO1.setId(null);
        assertThat(directionRegionaleDTO1).isNotEqualTo(directionRegionaleDTO2);
    }
}
