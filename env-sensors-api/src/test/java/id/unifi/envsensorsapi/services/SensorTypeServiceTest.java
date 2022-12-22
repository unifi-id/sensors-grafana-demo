package id.unifi.envsensorsapi.services;

import id.unifi.envsensorsapi.persistence.models.environmental.SensorType;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties", "classpath:test.properties"})
public class SensorTypeServiceTest {

    private final String SENSOR_TYPE = "Temperature";

    private SensorType sensorType;

    @Autowired
    private SensorTypeService sensorTypeService;

    @MockBean
    private RabbitMQReceiver rabbitMQReceiver;

    @BeforeEach
    void initSensorType() {
        sensorType = sensorTypeService.getOrCreateSensorType(SENSOR_TYPE);
    }

    @Test
    public void givenMockedRabbitMQReceiver_whenAppContextLoads_thenItWillBeMounted() {
        assertThat(rabbitMQReceiver).isNotNull();
    }

    @Test
    public void givenSensorTypeService_whenGetOrCreateNewSensorType_thenWillReturnNewlyCreatedOne() {
        assertThat(sensorType.getTitle()).isNotNull();
    }

    @Test
    public void givenSensorTypeService_whenGetOrCreateExistingSensorType_thenWillReturnExistingOne() {
        assertThat(sensorType.getTitle()).isEqualTo(SENSOR_TYPE);
    }

}
