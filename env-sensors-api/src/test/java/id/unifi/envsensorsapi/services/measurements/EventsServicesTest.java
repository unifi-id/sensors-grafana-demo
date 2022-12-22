package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.repositories.*;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQReceiver;
import id.unifi.envsensorsapi.utils.ObjectMapperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties", "classpath:test.properties"})
public class EventsServicesTest {

    private MeasurementDto measurementDto;

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private Co2Repository co2Repository;

    @Autowired
    private DeskOccupancyRepository deskOccupancyRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private PressureRepository pressureRepository;

    @Autowired
    private ObjectPresentRepository objectPresentRepository;

    @Autowired
    private MotionRepository motionRepository;

    @MockBean
    private RabbitMQReceiver rabbitMQReceiver;

    @Value("${test.temperature-event}")
    private String temperatureEvent;

    @Value("${test.humidity-event}")
    private String humidityEvent;

    @Value("${test.co2-event}")
    private String co2Event;

    @Value("${test.pressure-event}")
    private String pressureEvent;

    @Value("${test.desk-occupancy-event}")
    private String deskOccupancyEvent;

    @Value("${test.object-present-event}")
    private String objectPresentEvent;

    @Value("${test.motion-event}")
    private String motionEvent;

    @Test
    public void givenRabbitMQListener_whenAppContextLoads_thenIsNotEmpty() {
        assertThat(rabbitMQReceiver).isNotNull();
    }

    @Test
    public void givenMeasurementService_whenTemperatureEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(temperatureEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = temperatureRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenCo2Event_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(co2Event, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = co2Repository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenDeskOccupancyEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(deskOccupancyEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = deskOccupancyRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenHumidityEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(humidityEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = humidityRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenObjectPresentEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(objectPresentEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = objectPresentRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenPressureEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(pressureEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = pressureRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

    @Test
    public void givenMeasurementService_whenMotionEvent_thenIsCorrectlyProcessed() {
        measurementDto = ObjectMapperUtil.convertValue(motionEvent, MeasurementDto.class);
        measurementService.storeMeasurement(measurementDto);

        var allItems = motionRepository.findAll();

        assertThat(allItems.size()).isEqualTo(1);
    }

}
