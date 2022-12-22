package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Co2;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;

public class Co2EntityFactory {

    public static Co2 build(Sensor sensor, MeasurementDto dto) {
        var value = dto.event.data.co2.ppm;

        return Co2.builder()
                .sensor(sensor)
                .createdAt(Instant.now())
                .value(value)
                .build();
    }

}
