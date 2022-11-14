package com.kma.demo.service;

import com.kma.demo.entity.User;
import com.kma.demo.exceptions.EmptyParameterException;
import com.kma.demo.exceptions.InvalidParameterException;
import com.kma.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public User createUser(Integer id, String email, String password, Integer role) throws EmptyParameterException, InvalidParameterException {
        if (id == null || email == null || password == null || role == null) throw new EmptyParameterException();
        if (id < 0 || id > 1000 || email.length() > 100 || !email.matches(".*@gmail\\.com") || password.length() > 100 || role < 1 || role > 2) throw new InvalidParameterException();

        User user = new User(id, email, password, role);
        userRepository.save(user);
        return user;
    }
}
