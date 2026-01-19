package com.iuc.event_management.service;
import com.iuc.event_management.dto.request.EventRequest;
import com.iuc.event_management.dto.response.EventResponse;
import com.iuc.event_management.entity.Event;
import com.iuc.event_management.entity.User;
import com.iuc.event_management.mapper.EventMapper;
import com.iuc.event_management.repository.EventRepository;
import com.iuc.event_management.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepo;
    private final UserRepository userRepo;
    private final EventMapper mapper;

    public EventService(EventRepository eventRepo, UserRepository userRepo, EventMapper mapper) {
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public EventResponse createEvent(EventRequest request, String email) {
        User organizer = userRepo.findByEmail(email).orElseThrow();
        Event event = mapper.toEntity(request, organizer);
        return mapper.toDto(eventRepo.save(event));
    }

    public List<EventResponse> getAllEvents() {
        return eventRepo.findAll().stream().map(mapper::toDto).toList();
    }
}

