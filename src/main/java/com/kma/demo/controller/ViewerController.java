package com.kma.demo.controller;

import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("/viewer")
    public String page() {
        return "viewers-profile";
    }

    @GetMapping("/filterTest")
    @ResponseBody
    public String filterTest() {
        return "<html> <body> <h1> Shouldn't show </h1> </body> </html>";
    }

    @GetMapping("/error")
    public String error404() {
        return "viewer-page-error404";
    }
}
