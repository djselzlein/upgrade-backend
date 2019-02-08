package com.djselzlein.upgrade.upgradebackend.domain.service.dto;

import com.djselzlein.upgrade.upgradebackend.domain.validator.ArrivalDateConstraint;
import com.djselzlein.upgrade.upgradebackend.domain.validator.ReservationDurationConstraint;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ReservationDurationConstraint
public class ReservationDTO {

    @NotEmpty
    private String userEmail;

    @NotEmpty
    private String userName;

    @NotNull
    @ArrivalDateConstraint
    private LocalDate arrivalDate;

    @NotNull
    private LocalDate departureDate;

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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
