package com.iuc.event_management.mapper;

import com.iuc.event_management.dto.request.EventRequest;
import com.iuc.event_management.dto.response.EventResponse;
import com.iuc.event_management.entity.Event;
import com.iuc.event_management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event toEntity(EventRequest request, User organizer) {
        Event event = new Event();
        event.setName(request.title);
        event.setDescription(request.description);
        event.setDate(request.date);
        event.setLocation(request.location);
        event.setOrganiser(organizer);
        return event;
    }

    public EventResponse toDto(Event event) {
        EventResponse dto = new EventResponse();
        dto.id = Long.valueOf(event.getId());
        dto.title = event.getName();
        dto.description = event.getDescription();
        dto.date = event.getDate();
        dto.location = event.getLocation();
        return dto;
    }
}
