package com.djselzlein.upgrade.upgradebackend.domain.model;

import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
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

}
