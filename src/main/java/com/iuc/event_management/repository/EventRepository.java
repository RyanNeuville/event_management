package com.iuc.event_management.repository;

import com.iuc.event_management.entity.Event;
import com.iuc.event_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganiser(User organiser);
}
