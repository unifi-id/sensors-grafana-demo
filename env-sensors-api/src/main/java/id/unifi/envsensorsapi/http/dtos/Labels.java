package id.unifi.envsensorsapi.http.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import id.unifi.envsensorsapi.http.dtos.config.DtoConstants;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Labels {

    @JsonSetter(nulls = Nulls.SKIP)
    public String name = DtoConstants.DEFAULT_EMPTY_VALUES_REPLACEMENT;

}
