package com.iuc.event_management.controller;
import com.iuc.event_management.dto.request.PaymentRequest;
import com.iuc.event_management.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/{reservationId}")
    public void pay(@PathVariable Long reservationId,
                    @RequestBody PaymentRequest request) {
        service.pay(reservationId, request);
    }
}
