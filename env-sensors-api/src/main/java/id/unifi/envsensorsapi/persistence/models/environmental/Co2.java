package id.unifi.envsensorsapi.persistence.models.environmental;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "environmental", name = "co2")
public class Co2 extends RepresentationModel<Co2> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}
