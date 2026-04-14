package StreetPulse.StreetPulse.repository;

import StreetPulse.StreetPulse.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository <Business, Long> {
}
