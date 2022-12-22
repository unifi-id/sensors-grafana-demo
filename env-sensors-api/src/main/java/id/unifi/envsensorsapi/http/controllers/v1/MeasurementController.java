package id.unifi.envsensorsapi.http.controllers.v1;

import id.unifi.envsensorsapi.http.config.CustomResponse;
import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.rabbitmq.RabbitMQSender;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(MeasurementDto.class)
@RequestMapping("/v1/measurements")
@Tag(name = "Measurement", description = "Measurements processing")
public class MeasurementController {

    private final RabbitMQSender rabbitMQSender;

    public MeasurementController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<CustomResponse> store(@RequestBody MeasurementDto dto) {
        rabbitMQSender.send(dto);

        return new ResponseEntity<>(new CustomResponse(true, "Operation finished"), HttpStatus.CREATED);
    }

}
