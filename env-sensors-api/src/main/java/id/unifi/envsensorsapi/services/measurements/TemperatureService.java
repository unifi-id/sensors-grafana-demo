package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.TemperatureEntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.TemperatureRepository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService implements IMeasurementService {

    private final TemperatureRepository repository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.repository = temperatureRepository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = TemperatureEntityFactory.build(sensor, measurementDto);

        repository.save(model);
    }
}
