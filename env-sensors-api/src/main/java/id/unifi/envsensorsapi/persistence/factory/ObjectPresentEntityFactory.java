package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.ObjectPresent;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;
import java.util.Map;

public class ObjectPresentEntityFactory {

    private static final Map<String, Boolean> STATES = Map.of(
            "PRESENT", true,
            "NOT_PRESENT", false
    );

    public static ObjectPresent build(Sensor sensor, MeasurementDto dto) {
        var isPresent = STATES.getOrDefault(dto.event.data.objectPresent.state, false);

        return ObjectPresent.builder()
                .sensor(sensor)
                .isPresent(isPresent)
                .createdAt(Instant.now())
                .build();
    }

}
