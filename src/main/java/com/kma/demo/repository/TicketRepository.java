package com.kma.demo.repository;

import com.kma.demo.entity.Ticket;
import com.kma.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
