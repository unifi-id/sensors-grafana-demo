package id.unifi.envsensorsapi.persistence.repositories;

import id.unifi.envsensorsapi.persistence.models.environmental.Pressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PressureRepository extends JpaRepository<Pressure, Long> {
}
