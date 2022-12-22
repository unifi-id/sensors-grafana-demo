package id.unifi.envsensorsapi.persistence.factory;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.DeskOccupancy;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

import java.time.Instant;
import java.util.Map;

public class DeskOccupancyEntityFactory {

    private static final Map<String, Boolean> STATES = Map.of(
            "OCCUPIED", true,
            "NOT_OCCUPIED", false
    );

    public static DeskOccupancy build(Sensor sensor, MeasurementDto dto) {
        var isPresent = STATES.getOrDefault(dto.event.data.deskOccupancy.state, false);

        return DeskOccupancy.builder()
                .sensor(sensor)
                .isPresent(isPresent)
                .createdAt(Instant.now())
                .build();
    }

}
