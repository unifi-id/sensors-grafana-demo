package id.unifi.envsensorsapi.services.measurements.abstraction;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.persistence.models.environmental.Sensor;

public interface IMeasurementService {

    void store(Sensor sensor, MeasurementDto measurementDto);

}
