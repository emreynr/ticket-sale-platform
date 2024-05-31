package com.ecommerce.ecommerce_project.service;

import com.ecommerce.ecommerce_project.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket findById(int ticketId);
    List<Ticket> findAll();

    // save a ticket
    void saveTicket(Ticket theTicket);

    //update ticket
    void updateTicket(Ticket theTicket);

    // delete ticket
    void deleteTicket(int ticketId);

    // CRUD actions for tickets
}
