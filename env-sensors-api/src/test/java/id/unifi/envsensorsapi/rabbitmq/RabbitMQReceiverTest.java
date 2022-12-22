package id.unifi.envsensorsapi.rabbitmq;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.services.measurements.MeasurementService;
import id.unifi.envsensorsapi.utils.ObjectMapperUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RabbitMQReceiverTest {

    private RabbitMQReceiver rabbitMQReceiver;
    private MeasurementService measurementService;

    @Value("${test.temperature-event}")
    private String measurementDtoSerialised;

    private MeasurementDto measurementDto;

    @BeforeAll
    void setUp() {
        measurementDto = ObjectMapperUtil.convertValue(measurementDtoSerialised, MeasurementDto.class);
        measurementService = mock(MeasurementService.class);
        rabbitMQReceiver = new RabbitMQReceiver(measurementService);
    }

    @Test
    public void testReceiving() {
        assertThatCode(() -> rabbitMQReceiver.receiver(measurementDto)).doesNotThrowAnyException();

        Mockito.verify(measurementService, times(1)).storeMeasurement(measurementDto);
    }

}
