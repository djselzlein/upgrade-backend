package com.djselzlein.upgrade.upgradebackend.web;

import com.djselzlein.upgrade.upgradebackend.domain.service.ReservationService;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping({"", "/"})
    public Long create(@RequestBody ReservationDTO reservationDTO) {
        return service.create(reservationDTO);
    }

}
