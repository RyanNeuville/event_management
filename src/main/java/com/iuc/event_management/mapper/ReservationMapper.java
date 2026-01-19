package com.iuc.event_management.mapper;
import com.iuc.event_management.dto.response.ReservationResponse;
import com.iuc.event_management.entity.Event;
import com.iuc.event_management.entity.Reservation;
import com.iuc.event_management.entity.User;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ReservationMapper {
    public Reservation toEntity(User user, Event event) {
        Reservation r = new Reservation();
        r.setUser(user);
        r.setEvent(event);
        r.setDate(LocalDate.now());
        r.setStatus(false);
        return r;
    }

    public ReservationResponse toDto(Reservation r) {
        ReservationResponse dto = new ReservationResponse();
        dto.id = r.getId();
        dto.date = r.getDate();
        dto.status = r.getStatus();
        dto.eventId = Long.valueOf(r.getEvent().getId());
        return dto;
    }
}
