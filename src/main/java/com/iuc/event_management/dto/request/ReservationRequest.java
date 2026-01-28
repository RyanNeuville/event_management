package com.iuc.event_management.dto.request;

public class ReservationRequest {
    public Long eventId;

    public ReservationRequest() {
    }

    public ReservationRequest(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
