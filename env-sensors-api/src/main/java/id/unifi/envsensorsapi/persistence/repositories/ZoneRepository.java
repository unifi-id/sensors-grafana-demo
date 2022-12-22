package id.unifi.envsensorsapi.persistence.repositories;

import id.unifi.envsensorsapi.persistence.models.core.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
