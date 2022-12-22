package id.unifi.envsensorsapi.persistence.repositories;

import id.unifi.envsensorsapi.persistence.models.environmental.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {

    SensorType findByTitle(String title);

}
