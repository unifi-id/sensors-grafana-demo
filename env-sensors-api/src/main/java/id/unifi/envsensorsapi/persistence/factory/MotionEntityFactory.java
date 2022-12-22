package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Motion;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;
import java.util.Map;

public class MotionEntityFactory {

    private static final Map<String, Boolean> STATES = Map.of(
            "MOTION_DETECTED", true,
            "MOTION_NOT_DETECTED", false
    );

    public static Motion build(Sensor sensor, MeasurementDto dto) {
        var isPresent = STATES.getOrDefault(dto.event.data.motion.state, false);

        return Motion.builder()
                .sensor(sensor)
                .isPresent(isPresent)
                .createdAt(Instant.now())
                .build();
    }

}
