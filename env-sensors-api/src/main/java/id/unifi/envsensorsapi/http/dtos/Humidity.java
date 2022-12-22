package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Humidity {
    public int temperature;
    public double relativeHumidity;
    public Date updateTime;
}
