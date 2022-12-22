package id.unifi.envsensorsapi.rabbitmq;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:rabbitmq.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RabbitMQSenderTest {

    private RabbitMQSender rabbitMQSender;
    private RabbitTemplate rabbitTemplateMock;

    @BeforeAll
    void setUp() {
        rabbitTemplateMock = mock(RabbitTemplate.class);
        var queue = mock(Queue.class);

        rabbitMQSender = new RabbitMQSender(rabbitTemplateMock, queue);
    }

    @Test
    public void testSending() {
        var dto = new MeasurementDto();
        assertThatCode(() -> rabbitMQSender.send(dto)).doesNotThrowAnyException();

        verify(rabbitTemplateMock, times(1))
                .convertAndSend(any(), any(MeasurementDto.class));
    }

}
