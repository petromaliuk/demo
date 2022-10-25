package com.kma.demo.controller;

import com.kma.demo.entity.User;
import com.kma.demo.repository.UserRepository;
import com.kma.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private SeanceService seanceService;
    @Autowired
    private TicketService ticketService;

    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<html> <body> <h1> HELLO </h1> </body> </html>";
    }

    @GetMapping("/post")
    @ResponseBody
    public String post() {
        userRepository.save(new User(1, "a", "aa", 1));
        userRepository.save(new User(2, "b", "bb", 2));
        userRepository.save(new User(3, "c", "cc", 2));
        userRepository.save(new User(4, "d", "dd", 1));

        return "<html> <body> <h1> POSTED </h1> </body> </html>";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public String getAll() {
        StringBuilder builder = new StringBuilder();
        userRepository.findAll().forEach(user -> builder.append(user.toString()).append(", "));

        return "<html> <body> <h1> "+builder+" </h1> </body> </html>";
    }
}
