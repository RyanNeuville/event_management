package com.iuc.event_management.dto.response;
import java.time.LocalDate;
public class ReservationResponse {
    public Long id;
    public LocalDate date;
    public Boolean status;
    public Long eventId;

    public ReservationResponse() {
    }

    public ReservationResponse(Long id, LocalDate date, Boolean status, Long eventId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.eventId = eventId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
