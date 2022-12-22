package id.unifi.envsensorsapi.persistence.models.environmental;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "environmental", name = "humidity")
public class Humidity extends RepresentationModel<Humidity> {

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
