package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.PressureEntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.PressureRepository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class PressureService implements IMeasurementService {

    private final PressureRepository repository;

    public PressureService(PressureRepository co2Repository) {
        this.repository = co2Repository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = PressureEntityFactory.build(sensor, measurementDto);
        repository.save(model);
    }
}
