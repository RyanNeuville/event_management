package com.iuc.event_management.dto.response;

public class TicketResponse {
    public String id;
    public String titre;
    public String description;

    public TicketResponse() {
    }

    public TicketResponse(String id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
