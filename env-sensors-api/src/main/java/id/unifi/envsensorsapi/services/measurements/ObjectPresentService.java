package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.ObjectPresentEntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.ObjectPresentRepository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class ObjectPresentService implements IMeasurementService {

    private final ObjectPresentRepository repository;

    public ObjectPresentService(ObjectPresentRepository co2Repository) {
        this.repository = co2Repository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = ObjectPresentEntityFactory.build(sensor, measurementDto);
        repository.save(model);
    }

}
