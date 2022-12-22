package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Pressure;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;

public class PressureEntityFactory {

    public static Pressure build(Sensor sensor, MeasurementDto dto) {
        var value = dto.event.data.pressure.pascal;

        return Pressure.builder()
                .sensor(sensor)
                .createdAt(Instant.now())
                .value(value)
                .build();
    }

}
