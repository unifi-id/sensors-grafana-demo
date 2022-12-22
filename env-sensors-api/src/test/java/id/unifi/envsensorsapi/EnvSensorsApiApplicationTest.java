package id.unifi.envsensorsapi;

import id.unifi.envsensorsapi.http.controllers.v1.MeasurementController;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQReceiver;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class EnvSensorsApiApplicationTest {

    @Autowired
    private MeasurementController controller;

    @MockBean
    private RabbitMQSender rabbitMQSender;

    @MockBean
    private RabbitMQReceiver rabbitMQReceiver;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(rabbitMQSender).isNotNull();
        assertThat(rabbitMQReceiver).isNotNull();
    }

}
