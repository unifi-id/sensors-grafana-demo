package id.unifi.envsensorsapi.utils;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = {"classpath:test.properties"})
public class ObjectMapperUtilTest {

    @Test
    void testMeasurementDtoDeserialisationWillReturnNull() {
        var measurementDto = ObjectMapperUtil.convertValue("anyRandomString", MeasurementDto.class);

        assertThat(measurementDto).isNull();
    }

}
