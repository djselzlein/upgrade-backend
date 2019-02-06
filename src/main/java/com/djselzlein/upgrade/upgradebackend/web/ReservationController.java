package com.djselzlein.upgrade.upgradebackend.web;

import com.djselzlein.upgrade.upgradebackend.domain.model.Reservation;
import com.djselzlein.upgrade.upgradebackend.domain.service.ReservationService;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping({"", "/"})
    public Long create(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.create(reservationDTO);
    }

    @GetMapping("/")
    public List<Reservation> getAll() {
        return new ArrayList<>();
    }

}
