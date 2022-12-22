package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sample {
    public int value;
    public Date sampleTime;
}
