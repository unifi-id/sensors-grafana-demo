package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.models.environmental.Temperature;

import java.time.Instant;

public class TemperatureEntityFactory {

    public static Temperature build(Sensor sensor, MeasurementDto dto) {
        var value = dto.event.data.temperature.value;

        return Temperature.builder()
                .sensor(sensor)
                .createdAt(Instant.now())
                .value(value)
                .build();
    }

}
