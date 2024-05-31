package com.ecommerce.ecommerce_project.controller;

import com.ecommerce.ecommerce_project.entity.Ticket;
import com.ecommerce.ecommerce_project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    private TicketService theTicketService;

    @Autowired
    public TicketController(TicketService TicketService) {
        theTicketService = TicketService;
    }

    @GetMapping("/listAllTicket")
    public String listAllTicket(Model model) {

        List<Ticket> theTicket = theTicketService.findAll();

        model.addAttribute("theTicket", theTicket);

        return "admin/all-tickets";
    }

    @GetMapping("/ShowFormForAddTicket")
    public String ShowFormForAddTicket(Model model) {

        Ticket ticket = new Ticket();

        model.addAttribute("theTicket", ticket);

        return "admin/edit-ticket";
    }

    @PostMapping("/ticketSave")
    public String ticketSave(@ModelAttribute("theTicket") Ticket ticket) {

        theTicketService.saveTicket(ticket);

        return "redirect:/ticket/listAllTicket";
    }

    @GetMapping("/ShowFormForUpdateTicket")
    public String showFormForUpdateTicket(@RequestParam("ticketId") int theId, Model model) {

        Ticket getAnTicket = theTicketService.findById(theId);

        model.addAttribute("theTicket", getAnTicket);

        return "admin/edit-ticket";
    }

    @GetMapping("/DeleteTicket")
    public String deleteTicket(@RequestParam("ticketId") int theId) {

        theTicketService.deleteTicket(theId);

        return "redirect:/ticket/listAllTicket";
    }
}
