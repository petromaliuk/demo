package com.kma.demo.controller;

import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    private FeedbackService feedbackService;
    private FilmService filmService;
    private SeanceService seanceService;
    private TicketService ticketService;
    private UserService userService;

    @Autowired
    public AdminController(FeedbackService feedbackService, FilmService filmService, SeanceService seanceService, TicketService ticketService, UserService userService) {
        this.feedbackService = feedbackService;
        this.filmService = filmService;
        this.seanceService = seanceService;
        this.ticketService = ticketService;
        this.userService = userService;
    }
}
