package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.factory.DeskOccupancyEntityFactory;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;
import id.unifi.envsensorsapi.persistence.repositories.DeskOccupancyRepository;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class DeskOccupancyService implements IMeasurementService {

    private final DeskOccupancyRepository repository;

    public DeskOccupancyService(DeskOccupancyRepository co2Repository) {
        this.repository = co2Repository;
    }

    @Override
    public void store(Sensor sensor, MeasurementDto measurementDto) {
        var model = DeskOccupancyEntityFactory.build(sensor, measurementDto);
        repository.save(model);
    }

}
