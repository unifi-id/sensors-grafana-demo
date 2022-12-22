package id.unifi.envsensorsapi.services;

import id.unifi.envsensorsapi.persistence.models.environmental.SensorType;
import id.unifi.envsensorsapi.persistence.repositories.SensorTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypeService(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    public SensorType getOrCreateSensorType(String title) {
        var sensorType = sensorTypeRepository.findByTitle(title);

        return Objects.nonNull(sensorType)
                ? sensorType
                : createNewSensorType(title);
    }

    private SensorType createNewSensorType(String title) {
        var newSensorType = new SensorType();
        newSensorType.setTitle(title);

        sensorTypeRepository.save(newSensorType);

        return newSensorType;
    }

}
