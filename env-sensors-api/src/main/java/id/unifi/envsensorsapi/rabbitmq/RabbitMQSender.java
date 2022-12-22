package id.unifi.envsensorsapi.rabbitmq;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.utils.LoggerUtil;
import io.vavr.control.Try;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;
    private final Queue queue;

    public RabbitMQSender(AmqpTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(MeasurementDto dto) {
        Try.run(() -> {
            rabbitTemplate.convertAndSend(queue.getName(), dto);
            LoggerUtil.info(dto.event.eventType + "event detected");
        }).onFailure(exception -> LoggerUtil.error(exception.getMessage(), dto));
    }

}
