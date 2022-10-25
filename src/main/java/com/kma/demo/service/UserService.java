package com.kma.demo.service;

import com.kma.demo.entity.User;
import com.kma.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmailAndPassword(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) return null;

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) return user;
        }
        return null;
    }
}
