package id.unifi.envsensorsapi.persistence.models.environmental;

import id.unifi.envsensorsapi.persistence.models.core.Zone;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sensor", schema = "environmental")
public class Sensor extends RepresentationModel<Sensor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_id", nullable = false, length = 64)
    private String deviceId;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", length = 64)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensor_type_id", nullable = false)
    private SensorType sensorType;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "sensor")
    private Set<Humidity> humiditySet = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sensor")
    private Set<Temperature> temperatureSet = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sensor")
    private Set<Co2> co2Set = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sensor")
    private Set<ObjectPresent> proximitySet = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sensor")
    private Set<Pressure> pressures = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sensor")
    private Set<DeskOccupancy> deskOccupancies = new LinkedHashSet<>();

}
