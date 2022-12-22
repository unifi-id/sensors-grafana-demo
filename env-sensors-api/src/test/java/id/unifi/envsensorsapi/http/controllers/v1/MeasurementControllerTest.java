package id.unifi.envsensorsapi.http.controllers.v1;

import id.unifi.envsensorsapi.rabbitmq.RabbitMQSender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurementController.class)
@TestPropertySource(locations = "classpath:test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MeasurementControllerTest {

    private static final String ENDPOINT_SLUG = "/v1/measurements";
    private static final String CHARACTER_ENCODING = "UTF-8";

    private MockMvc mockMvc;

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

    @MockBean
    private RabbitMQSender rabbitMQSender;

    @BeforeAll
    void setup(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenMockMVC_whenRequestingWrongEndpoint_willReturnNotFound() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG + "/dummy"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenSendingEmptyRequest_willReturnUnprocessable() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG))
                .andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingTemperatureEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(temperatureEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingCo2Event_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(co2Event)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingPressureEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pressureEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingDeskOccupancyEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(deskOccupancyEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingHumidityEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(humidityEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingObjectPresentEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectPresentEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

    @Test
    @WithMockUser(username = "user")
    public void givenMockMVC_whenProcessingMotionEvent_willReturnCreatedStatus() throws Exception {
        mockMvc.perform(post(ENDPOINT_SLUG)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(motionEvent)
                        .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().is(HttpStatus.CREATED.value()));

        verify(rabbitMQSender, times(1)).send(any());
    }

}
