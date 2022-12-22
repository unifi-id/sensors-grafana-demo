package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    public Co2 co2;
    public Humidity humidity;
    public Temperature temperature;
    public ObjectPresent objectPresent;
    public DeskOccupancy deskOccupancy;
    public Pressure pressure;
    public Motion motion;
}
