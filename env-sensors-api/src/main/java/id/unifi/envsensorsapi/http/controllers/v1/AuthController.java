package id.unifi.envsensorsapi.http.controllers.v1;

import com.mashape.unirest.http.Unirest;
import id.unifi.envsensorsapi.http.dtos.MeasurementDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@ExposesResourceFor(MeasurementDto.class)
@RequestMapping("/v1/auth")
@Tag(name = "Measurement", description = "Measurements processing")
public class AuthController {

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Void> redirect(@PathVariable int id) throws Exception {
        var response = Unirest.post("https://grafana.unifi-id.click")
                .header("Content-Type", "application/json")
                .body("{\"user\":\"test\",\"password\":\"test\"}")
                .asJson();

        var cookie = response.getHeaders().getFirst("Set-Cookie");

        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", "Bearer glsa_VElnuclQjcEbOuxuYkcDIN524FYZtrfp_c09e2382")
                .header("Set-Cookie", cookie)
                .location(URI.create("https://grafana.unifi-id.click/"))
                .build();
    }
}
