package com.djselzlein.upgrade.upgradebackend.domain.service.dto;

import java.time.LocalDate;

public class AvailabilityDTO {

    private LocalDate date;

    private boolean available;

    public AvailabilityDTO(LocalDate date, Boolean available) {
        this.date = date;
        this.available = available;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
