package com.iuc.event_management.dto.request;

public class PaymentRequest {
    public Integer amount;
    public String description;

    public PaymentRequest() {

    }

    public PaymentRequest(Integer amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
