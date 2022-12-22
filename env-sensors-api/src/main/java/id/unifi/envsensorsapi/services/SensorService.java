package id.unifi.envsensorsapi.services;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.core.Zone;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.SensorRepository;
import id.unifi.envsensorsapi.persistence.repositories.ZoneRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final ZoneRepository zoneRepository;
    private final SensorTypeService sensorTypeService;

    public SensorService(SensorRepository sensorRepository, ZoneRepository zoneRepository, SensorTypeService sensorTypeService) {
        this.sensorRepository = sensorRepository;
        this.zoneRepository = zoneRepository;
        this.sensorTypeService = sensorTypeService;
    }

    public Sensor getOrCreateSensor(MeasurementDto measurementDto) {
        var metadata = measurementDto.metadata;
        var labels = measurementDto.labels;

        var sensor = sensorRepository.findByDeviceId(metadata.deviceId);

        return Objects.nonNull(sensor)
                ? sensor
                : createSensor(metadata.deviceId, labels.name, metadata.deviceType);
    }

    private Sensor createSensor(String sensorDeviceId, String sensorTitle, String sensorTypeTitle) {
        var sensorType = sensorTypeService.getOrCreateSensorType(sensorTypeTitle);

        var sensor = new Sensor();
        sensor.setDeviceId(sensorDeviceId);
        sensor.setTitle(sensorTitle);
        sensor.setSensorType(sensorType);
        sensor.setCreatedAt(Instant.now());
        sensor.setZone(getFirstZone());

        sensorRepository.save(sensor);

        return sensor;
    }

    private Zone getFirstZone() {
        var zone = zoneRepository.findById(1L);
        return zone.orElseGet(Zone::new);
    }

}
