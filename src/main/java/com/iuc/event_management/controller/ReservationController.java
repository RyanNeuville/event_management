package com.iuc.event_management.controller;
import com.iuc.event_management.dto.request.ReservationRequest;
import com.iuc.event_management.dto.response.ReservationResponse;
import com.iuc.event_management.service.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    public ReservationResponse reserve(@RequestBody ReservationRequest request,
                                       Authentication auth) {
        return service.reserve(auth.getName(), request);
    }
}
