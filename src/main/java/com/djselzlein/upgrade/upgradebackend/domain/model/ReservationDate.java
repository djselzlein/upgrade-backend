package com.djselzlein.upgrade.upgradebackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class ReservationDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private LocalDate date;

    @ManyToOne
    private Reservation reservation;

    public ReservationDate() {
    }

    public ReservationDate(LocalDate date, Reservation reservation) {
        this.date = date;
        this.reservation = reservation;
    }

    public ReservationDate(Long id, LocalDate date, Reservation reservation) {
        this.id = id;
        this.date = date;
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

}
