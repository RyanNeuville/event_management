package com.iuc.event_management.dto.request;
import java.time.LocalDate;
public class EventRequest {
    public String title;
    public String description;
    public LocalDate date;
    public String location;
    public String image;

    public EventRequest() {
    }

    public EventRequest(String title, String description, LocalDate date, String location, String image) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
