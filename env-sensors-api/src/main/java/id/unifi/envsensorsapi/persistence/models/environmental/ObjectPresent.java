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
@Table(schema = "environmental", name = "object_present")
public class ObjectPresent extends RepresentationModel<ObjectPresent> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Column(name = "is_present", nullable = false)
    private Boolean isPresent = false;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}
