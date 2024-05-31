package com.ecommerce.ecommerce_project.dao;

import com.ecommerce.ecommerce_project.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
