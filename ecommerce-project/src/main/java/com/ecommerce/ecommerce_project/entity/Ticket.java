package com.ecommerce.ecommerce_project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "ticket_category")
    private String ticketCategory;

    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "ticket_features")
    private String ticketFeatures;

    @Column(name = "ticket_count")
    private int ticketCount;

    @Column(name = "ticket_date")
    private String ticketDate;

    public Ticket() {}

    public Ticket (String ticketName, String ticketCategory, int ticketPrice, String ticketFeatures, int ticketCount, String ticketDate) {
        this.ticketName = ticketName;
        this.ticketCategory = ticketCategory;
        this.ticketPrice = ticketPrice;
        this.ticketFeatures = ticketFeatures;
        this.ticketCount = ticketCount;
        this.ticketDate = ticketDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketFeatures() {
        return ticketFeatures;
    }

    public void setTicketFeatures(String ticketFeatures) {
        this.ticketFeatures = ticketFeatures;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketName='" + ticketName + '\'' +
                ", ticketCategory='" + ticketCategory + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketFeatures='" + ticketFeatures + '\'' +
                ", ticketCount=" + ticketCount +
                ", ticketDate='" + ticketDate + '\'' +
                '}';
    }
}