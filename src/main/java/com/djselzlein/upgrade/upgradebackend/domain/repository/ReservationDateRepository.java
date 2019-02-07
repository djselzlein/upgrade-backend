package com.djselzlein.upgrade.upgradebackend.domain.repository;

import com.djselzlein.upgrade.upgradebackend.domain.model.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationDateRepository extends JpaRepository<ReservationDate, Long> {

    List<ReservationDate> findAllByDateBetween(LocalDate start, LocalDate end);

    void deleteAllByReservationId(Long reservationId);

}
