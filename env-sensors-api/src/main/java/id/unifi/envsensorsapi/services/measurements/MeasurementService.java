package id.unifi.envsensorsapi.services.measurements;

import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import id.unifi.envsensorsapi.services.SensorService;
import id.unifi.envsensorsapi.services.config.ServiceResolver;
import id.unifi.envsensorsapi.utils.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MeasurementService {

    private final SensorService sensorService;
    private final ServiceResolver serviceResolver;

    public MeasurementService(SensorService sensorService, ServiceResolver serviceResolver) {
        this.sensorService = sensorService;
        this.serviceResolver = serviceResolver;
    }

    public void storeMeasurement(MeasurementDto measurementDto) {
        var sensor = sensorService.getOrCreateSensor(measurementDto);
        var event = measurementDto.event;

        var service = serviceResolver.getServiceByEventType(event.eventType);

        var eventType = measurementDto.event.eventType;

        if (Objects.nonNull(service)) {
            service.store(sensor, measurementDto);
            LoggerUtil.info(eventType + "event processed");
        } else {
            LoggerUtil.info(eventType + "event ignored");
        }
    }

}
