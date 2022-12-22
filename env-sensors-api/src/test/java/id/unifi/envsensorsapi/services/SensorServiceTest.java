package id.unifi.envsensorsapi.services;

import id.unifi.envsensorsapi.PostgreSqlTestContainer;
import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQReceiver;
import id.unifi.envsensorsapi.utils.ObjectMapperUtil;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties", "classpath:test.properties"})
public class SensorServiceTest {

    private final String SENSOR_TITLE = "EmulatedTemperatureSensor";
    private MeasurementDto measurementDto;

    @Autowired
    private SensorService sensorService;

    @MockBean
    private RabbitMQReceiver rabbitMQReceiver;

    @Value("${test.temperature-event}")
    private String measurementDtoSerialised;

    @ClassRule
    public static PostgreSQLContainer<PostgreSqlTestContainer> postgreSQLContainer;

    @BeforeEach
    void initDto() {
        measurementDto = ObjectMapperUtil.convertValue(measurementDtoSerialised, MeasurementDto.class);
    }

    @Test
    public void givenSensorTypeService_whenGetOrCreateNewSensorType_thenWillReturnNewlyCreatedOne() {
        var sensor = sensorService.getOrCreateSensor(measurementDto);

        assertThat(sensor.getTitle()).isEqualTo(SENSOR_TITLE);
    }

    @Test
    public void givenSensorTypeService_whenGetOrCreateExistingSensorType_thenWillReturnExistingOne() {
        var sensor = sensorService.getOrCreateSensor(measurementDto);

        assertThat(sensor.getTitle()).isEqualTo(SENSOR_TITLE);
    }

}
