package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import id.unifi.envsensorsapi.http.dtos.config.DtoConstants;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

    @JsonSetter(nulls = Nulls.SKIP)
    public String deviceId = DtoConstants.DEFAULT_EMPTY_VALUES_REPLACEMENT;

    @JsonSetter(nulls = Nulls.SKIP)
    public String deviceType = DtoConstants.DEFAULT_EMPTY_VALUES_REPLACEMENT;

}
