package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasurementDto {

    public Event event;
    public Labels labels;
    public Metadata metadata;

}
