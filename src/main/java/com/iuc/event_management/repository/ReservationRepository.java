package com.iuc.event_management.repository;

import com.iuc.event_management.entity.Reservation;
import com.iuc.event_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}
