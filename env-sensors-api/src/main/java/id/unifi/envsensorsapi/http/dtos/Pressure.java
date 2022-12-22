package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pressure {
    public double pascal;
    public Date updateTime;
}
