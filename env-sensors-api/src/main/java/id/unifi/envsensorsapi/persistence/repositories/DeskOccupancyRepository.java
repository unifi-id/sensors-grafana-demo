package id.unifi.envsensorsapi.persistence.repositories;

import id.unifi.envsensorsapi.persistence.models.environmental.DeskOccupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskOccupancyRepository extends JpaRepository<DeskOccupancy, Long> {
}
