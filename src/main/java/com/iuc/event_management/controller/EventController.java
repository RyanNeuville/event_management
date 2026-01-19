package com.iuc.event_management.controller;

import com.iuc.event_management.dto.request.EventRequest;
import com.iuc.event_management.dto.response.EventResponse;
import com.iuc.event_management.service.EventService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ORGANIZER')")
    @PostMapping
    public EventResponse create(@RequestBody EventRequest request, Authentication auth) {
        return service.createEvent(request, auth.getName());
    }

    @GetMapping
    public List<EventResponse> list() {
        return service.getAllEvents();
    }
}
