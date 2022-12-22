package id.unifi.envsensorsapi.persistence.repositories;

import id.unifi.envsensorsapi.persistence.models.environmental.Motion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotionRepository extends JpaRepository<Motion, Long> {
}
