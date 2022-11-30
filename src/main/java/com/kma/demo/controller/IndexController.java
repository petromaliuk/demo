package com.kma.demo.controller;


import com.kma.demo.entity.Film;
import com.kma.demo.entity.User;
import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
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

    //main page
    @GetMapping("/")
    public String mainPage (Model model) {
        List<Film> filmList = filmService.getAll();
        model.addAttribute("films", filmList);
    return "index";
    }


    @RequestMapping(value = "/delete-film", method = RequestMethod.POST)
    public String deleteRecipe(HttpSession session) {


        return "redirect:/";
    }







}
