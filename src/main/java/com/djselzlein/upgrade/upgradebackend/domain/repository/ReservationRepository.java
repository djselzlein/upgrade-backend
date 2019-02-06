package com.djselzlein.upgrade.upgradebackend.domain.repository;

import com.djselzlein.upgrade.upgradebackend.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
