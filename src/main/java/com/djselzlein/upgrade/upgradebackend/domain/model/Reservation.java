package com.djselzlein.upgrade.upgradebackend.domain.model;

import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String userEmail;

    @NotEmpty
    private String userName;

    @OneToMany(mappedBy = "reservation", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<ReservationDate> reservationDates;

    public Reservation() {
    }

    public Reservation(ReservationDTO dto) {
        this.userEmail = dto.getUserEmail();
        this.userName = dto.getUserName();
        this.reservationDates = new HashSet<>();

        for (LocalDate date = dto.getArrivalDate(); date.isBefore(dto.getDepartureDate()); date = date.plusDays(1)) {
            this.addReservationDate(new ReservationDate(date, this));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<ReservationDate> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(Set<ReservationDate> reservationDates) {
        this.reservationDates = reservationDates;
    }

    private void addReservationDate(ReservationDate reservationDate) {
        this.reservationDates.add(reservationDate);
    }

    public Reservation merge(ReservationDTO updateDTO) {
        this.userEmail = updateDTO.getUserEmail();
        this.userName = updateDTO.getUserName();
        mergeDates(updateDTO.getArrivalDate(), updateDTO.getDepartureDate());
        return this;
    }

    private void mergeDates(LocalDate arrivalDate, LocalDate departureDate) {
        Map<LocalDate, Long> existingReservation = new HashMap<>();
        for (ReservationDate reservationDate : reservationDates) {
            existingReservation.put(reservationDate.getDate(), reservationDate.getId());
        }

        this.reservationDates.clear();

        for (LocalDate date = arrivalDate; date.isBefore(departureDate); date = date.plusDays(1)) {
            this.addReservationDate(new ReservationDate(existingReservation.get(date), date, this));
        }
    }

}
