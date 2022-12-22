package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.utils.ObjectMapperUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntityFactoryTest {

    private Sensor sensor;

    @Value("${test.temperature-event}")
    private String temperatureEvent;

    @Value("${test.co2-event}")
    private String co2Event;

    @Value("${test.pressure-event}")
    private String pressureEvent;

    @Value("${test.desk-occupancy-event}")
    private String deskOccupancyEvent;

    @Value("${test.humidity-event}")
    private String humidityEvent;

    @Value("${test.object-present-event}")
    private String objectPresentEvent;

    @Value("${test.motion-event}")
    private String motionEvent;

    @BeforeAll
    void setup() {
        sensor = new Sensor();
    }

    @Test
    public void testTemperatureEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(temperatureEvent, MeasurementDto.class);
        assert dto != null;

        var entity = TemperatureEntityFactory.build(sensor, dto);

        assertThat(entity.getValue()).isEqualTo(26);
    }

    @Test
    public void testCo2EntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(co2Event, MeasurementDto.class);
        assert dto != null;

        var entity = Co2EntityFactory.build(sensor, dto);

        assertThat(entity.getValue()).isEqualTo(4269.0);
    }

    @Test
    public void testPressureEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(pressureEvent, MeasurementDto.class);
        assert dto != null;

        var entity = PressureEntityFactory.build(sensor, dto);

        assertThat(entity.getValue()).isEqualTo(98644);
    }

    @Test
    public void testDeskOccupancyEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(deskOccupancyEvent, MeasurementDto.class);
        assert dto != null;

        var entity = DeskOccupancyEntityFactory.build(sensor, dto);

        assertThat(entity.getIsPresent()).isTrue();
    }

    @Test
    public void testHumidityEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(humidityEvent, MeasurementDto.class);
        assert dto != null;

        var entity = HumidityEntityFactory.build(sensor, dto);

        assertThat(entity.getValue()).isEqualTo(65);
    }

    @Test
    public void testObjectPresentEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(objectPresentEvent, MeasurementDto.class);
        assert dto != null;

        var entity = ObjectPresentEntityFactory.build(sensor, dto);

        assertThat(entity.getIsPresent()).isTrue();
    }

    @Test
    public void testMotionEntityBuilder() {
        var dto = ObjectMapperUtil.convertValue(motionEvent, MeasurementDto.class);
        assert dto != null;

        var entity = MotionEntityFactory.build(sensor, dto);

        assertThat(entity.getIsPresent()).isTrue();
    }

}
