package com.iuc.event_management.service;
import com.iuc.event_management.dto.request.ReservationRequest;
import com.iuc.event_management.dto.response.ReservationResponse;
import com.iuc.event_management.entity.Event;
import com.iuc.event_management.entity.Reservation;
import com.iuc.event_management.entity.User;
import com.iuc.event_management.mapper.ReservationMapper;
import com.iuc.event_management.repository.EventRepository;
import com.iuc.event_management.repository.ReservationRepository;
import com.iuc.event_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepo;
    private final EventRepository eventRepo;
    private final UserRepository userRepo;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository reservationRepo,
                              EventRepository eventRepo,
                              UserRepository userRepo,
                              ReservationMapper mapper) {
        this.reservationRepo = reservationRepo;
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public ReservationResponse reserve(String email, ReservationRequest request) {
        User user = userRepo.findByEmail(email).orElseThrow();
        Event event = eventRepo.findById(request.eventId).orElseThrow();
        Reservation r = mapper.toEntity(user, event);
        return mapper.toDto(reservationRepo.save(r));
    }
}
