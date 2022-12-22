package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.MotionEntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.MotionRepository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class MotionService implements IMeasurementService {

    private final MotionRepository repository;

    public MotionService(MotionRepository co2Repository) {
        this.repository = co2Repository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = MotionEntityFactory.build(sensor, measurementDto);
        repository.save(model);
    }

}
