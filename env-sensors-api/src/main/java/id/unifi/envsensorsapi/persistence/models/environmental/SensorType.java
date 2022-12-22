package id.unifi.envsensorsapi.persistence.models.environmental;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sensor_type", schema = "environmental")
public class SensorType extends RepresentationModel<SensorType> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 32)
    private String title;

    @Column(name = "description", length = 64)
    private String description;

    @OneToMany(mappedBy = "sensorType")
    private Set<Sensor> sensors = new LinkedHashSet<>();

}
