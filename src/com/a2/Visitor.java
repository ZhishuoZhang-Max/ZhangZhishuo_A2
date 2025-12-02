package com.a2;

/**
 * Visitor class extends Person with ticket ID and ticket type
 */
public class Visitor extends Person {
    private String ticketId;
    private String ticketType;

    // Default constructor
    public Visitor() {
        super();
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String ticketId, String ticketType) {
        super(name, age, gender);
        this.ticketId = ticketId;
        this.ticketType = ticketType;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
