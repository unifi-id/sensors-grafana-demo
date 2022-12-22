package id.unifi.envsensorsapi.rabbitmq;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.services.measurements.MeasurementService;
import id.unifi.envsensorsapi.utils.LoggerUtil;
import io.vavr.control.Try;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RabbitMQReceiver {

    private final MeasurementService measurementService;

    public RabbitMQReceiver(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @RabbitHandler
    public void receiver(MeasurementDto dto) {
        Try.run(() -> measurementService.storeMeasurement(dto))
                .onFailure(exception -> LoggerUtil.error(exception.getMessage(), dto));
    }

}
