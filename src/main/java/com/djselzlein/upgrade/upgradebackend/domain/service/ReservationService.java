package com.djselzlein.upgrade.upgradebackend.domain.service;

import com.djselzlein.upgrade.upgradebackend.domain.model.Reservation;
import com.djselzlein.upgrade.upgradebackend.domain.repository.ReservationDateRepository;
import com.djselzlein.upgrade.upgradebackend.domain.repository.ReservationRepository;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationDateRepository reservationDateRepository;

    @Transactional
    public Long create(ReservationDTO createDTO) {
        final Reservation reservation = new Reservation(createDTO);
        repository.save(reservation);
        return reservation.getId();
    }

    @Transactional
    public void modify(Long id, ReservationDTO updateDTO) {
        final Reservation reservation = repository.findWithReservationDatesById(id);
        repository.save(reservation.merge(updateDTO));
    }

    @Transactional
    public void cancel(Long id) {
        reservationDateRepository.deleteAllByReservationId(id);
        repository.deleteById(id);
    }

}
