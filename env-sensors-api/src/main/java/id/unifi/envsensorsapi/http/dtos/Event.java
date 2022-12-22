package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    public String eventId;
    public String targetName;
    public String eventType;
    public Data data;
    public Date timestamp;
}
