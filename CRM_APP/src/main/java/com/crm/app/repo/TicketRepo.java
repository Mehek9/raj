package com.crm.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.app.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
