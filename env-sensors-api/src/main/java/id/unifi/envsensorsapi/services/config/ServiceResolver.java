package id.unifi.envsensorsapi.services.config;

import id.unifi.envsensorsapi.services.measurements.*;
import id.unifi.envsensorsapi.services.measurements.abstraction.IMeasurementService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ServiceResolver {

    private final HashMap<String, IMeasurementService> services;

    public ServiceResolver(ApplicationContext context) {
        services = new HashMap<>();

        services.put("temperature", context.getBean(TemperatureService.class));
        services.put("humidity", context.getBean(HumidityService.class));
        services.put("co2", context.getBean(Co2Service.class));
        services.put("pressure", context.getBean(PressureService.class));
        services.put("deskOccupancy", context.getBean(DeskOccupancyService.class));
        services.put("objectPresent", context.getBean(ObjectPresentService.class));
        services.put("motion", context.getBean(MotionService.class));
    }

    public IMeasurementService getServiceByEventType(String eventType) {
        return services.get(eventType);
    }

}
