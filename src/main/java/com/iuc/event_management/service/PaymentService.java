package com.iuc.event_management.service;
import com.iuc.event_management.dto.request.PaymentRequest;
import com.iuc.event_management.entity.Payment;
import com.iuc.event_management.entity.Reservation;
import com.iuc.event_management.repository.PaymentRepository;
import com.iuc.event_management.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepo;
    private final ReservationRepository reservationRepo;

    public PaymentService(PaymentRepository paymentRepo,
                          ReservationRepository reservationRepo) {
        this.paymentRepo = paymentRepo;
        this.reservationRepo = reservationRepo;
    }

    public void pay(Long reservationId, PaymentRequest request) {
        Reservation r = reservationRepo.findById(reservationId).orElseThrow();

        Payment p = new Payment();
        p.setAmount(request.amount);
        p.setDescription(request.description);
        p.setStatus("PAID");
        p.setDate(LocalDate.now());
        p.setReservation(r);

        r.setStatus(true);

        paymentRepo.save(p);
        reservationRepo.save(r);
    }
}
