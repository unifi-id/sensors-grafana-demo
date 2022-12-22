package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Humidity;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;

public class HumidityEntityFactory {

    public static Humidity build(Sensor sensor, MeasurementDto dto) {
        var value =dto.event.data.humidity.relativeHumidity;

        return Humidity.builder()
                .sensor(sensor)
                .createdAt(Instant.now())
                .value(value)
                .build();
    }

}
