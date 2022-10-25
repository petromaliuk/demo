package com.kma.demo.controller;

import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ViewerController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private SeanceService seanceService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
}
