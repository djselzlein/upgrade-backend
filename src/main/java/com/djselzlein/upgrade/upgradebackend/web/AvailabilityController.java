package com.djselzlein.upgrade.upgradebackend.web;

import com.djselzlein.upgrade.upgradebackend.domain.service.AvailabilityService;
import com.djselzlein.upgrade.upgradebackend.domain.service.dto.AvailabilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService service;

    @GetMapping("/")
    public List<AvailabilityDTO> getAvailabilityForPeriod(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getAvailabilityForPeriod(startDate, endDate);
    }

}
