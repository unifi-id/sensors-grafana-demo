package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.Co2EntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.Co2Repository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class Co2Service implements IMeasurementService {

    private final Co2Repository repository;

    public Co2Service(Co2Repository co2Repository) {
        this.repository = co2Repository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = Co2EntityFactory.build(sensor, measurementDto);
        repository.save(model);
    }
}
