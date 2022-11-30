package com.kma.demo.controller;

import com.kma.demo.entity.Film;
import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping({"/admin", ""})
    public String page() {
        return "admins-profile";
    }



    @RequestMapping(value = "/add-film", method = RequestMethod.POST)
    public String createRecipe(@RequestParam(name = "title") String title,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "category") String category,
                               @RequestParam(name = "duration") String duration) {


        Film film = new Film(1, title, description, category, Integer.valueOf(duration));

        filmService.save(film);

        return "forward:/admin";
    }

}
