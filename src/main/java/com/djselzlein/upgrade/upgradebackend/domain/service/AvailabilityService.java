package com.djselzlein.upgrade.upgradebackend.domain.service;

import com.djselzlein.upgrade.upgradebackend.domain.model.ReservationDate;
import com.djselzlein.upgrade.upgradebackend.domain.repository.ReservationDateRepository;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.AvailabilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AvailabilityService {

    @Autowired
    private ReservationDateRepository reservationDateRepository;

    public List<AvailabilityDTO> getAvailabilityForPeriod(LocalDate startDate, LocalDate endDate) {
        startDate = sanitizeStartDate(startDate);
        endDate = sanitizeEndDate(startDate, endDate);

        final List<ReservationDate> reservationDates = reservationDateRepository.findAllByDateBetween(startDate, endDate);
        final Map<LocalDate, Boolean> availabilityMap = new HashMap<>();

        buildReservedDatesMap(reservationDates, availabilityMap);

        return buildAvailabilityDTOs(startDate, endDate, availabilityMap);
    }

    private void buildReservedDatesMap(List<ReservationDate> reservationDates, Map<LocalDate, Boolean> availabilityMap) {
        for (ReservationDate reservationDate : reservationDates) {
            availabilityMap.put(reservationDate.getDate(), false);
        }
    }

    private List<AvailabilityDTO> buildAvailabilityDTOs(LocalDate startDate, LocalDate endDate, Map<LocalDate, Boolean> reservedDates) {
        List<AvailabilityDTO> availabilityDTOs = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            availabilityDTOs.add(new AvailabilityDTO(date, reservedDates.get(date) == null));
        }
        return availabilityDTOs;
    }

    private LocalDate sanitizeStartDate(LocalDate startDate) {
        return startDate == null ? LocalDate.now() : startDate;
    }

    private LocalDate sanitizeEndDate(LocalDate startDate, LocalDate endDate) {
        return endDate == null ? startDate.plusMonths(1) : endDate;
    }

}
