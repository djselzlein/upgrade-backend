package com.djselzlein.upgrade.upgradebackend.domain.service;

import com.djselzlein.upgrade.upgradebackend.domain.model.Reservation;
import com.djselzlein.upgrade.upgradebackend.domain.repository.ReservationRepository;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Transactional
    public Long create(ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation(reservationDTO);
        reservationRepository.save(reservation);
        return reservation.getId();
    }

}