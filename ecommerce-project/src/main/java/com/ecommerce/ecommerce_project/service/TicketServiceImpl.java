package com.ecommerce.ecommerce_project.service;


import com.ecommerce.ecommerce_project.dao.TicketRepository;
import com.ecommerce.ecommerce_project.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    // if we have multiple constructor for jpa repositories, we need add an autowired

    public TicketServiceImpl(TicketRepository theTicketRepository) {
        ticketRepository  = theTicketRepository;
    }


    @Override
    public Ticket findById(int ticketId) {

        Optional<Ticket> result = ticketRepository.findById(ticketId);

        Ticket tempTicket = null;

        if(result.isPresent()) {
            tempTicket = result.get();
        }
        else {
            throw new RuntimeException("Ticket not found with provided id : " + ticketId);
        }
        return tempTicket;
    }

    @Override
    public List<Ticket> findAll() {

        return ticketRepository.findAll();
    }

    @Override
    public void saveTicket(Ticket theTicket) {

        ticketRepository.save(theTicket);
    }

    @Override
    public void updateTicket(Ticket theTicket) {

        ticketRepository.save(theTicket);

    }

    @Override
    public void deleteTicket(int ticketId) {

        ticketRepository.deleteById(ticketId);
    }
}
