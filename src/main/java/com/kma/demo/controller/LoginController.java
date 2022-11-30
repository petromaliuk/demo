package com.kma.demo.controller;


import com.kma.demo.DemoApplication;
import com.kma.demo.entity.User;
import com.kma.demo.exceptions.EmptyParameterException;
import com.kma.demo.exceptions.InvalidParameterException;
import com.kma.demo.repository.UserRepository;
import com.kma.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


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
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        logger.info("Hello mapping was activated!");
        return "<html> <body> <h1> HELLO </h1> </body> </html>";
    }

    @GetMapping("/postTest")
    @ResponseBody
    public String postTest() {
        userRepository.save(new User(1, "a", "aa", 1));
        userRepository.save(new User(2, "b", "bb", 2));
        userRepository.save(new User(3, "c", "cc", 2));
        userRepository.save(new User(4, "d", "dd", 1));

        return "<html> <body> <h1> POSTED </h1> </body> </html>";
    }

    @GetMapping("/exceptionTest1")
    @ResponseBody
    public String exceptionTest1() throws EmptyParameterException, InvalidParameterException {
        userService.createUser(1, "my@gmail.ua", "2345", 1);
        return "<html> <body> <h1> No exception </h1> </body> </html>";
    }

    @GetMapping("/exceptionTest2")
    @ResponseBody
    public String exceptionTest2() throws EmptyParameterException, InvalidParameterException {
        userService.createUser(1, "my@gmail.com", null, 1);
        return "<html> <body> <h1> No exception </h1> </body> </html>";
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public String getAllUsers() {
        StringBuilder builder = new StringBuilder();
        userRepository.findAll().forEach(user -> builder.append("<li>").append(user.toString()).append("</li>"));
        return "<html> <body> <h1> Users: </h1> <ul> " + builder + " </ul> </body> </html>";
    }

    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User posted");
    }

    @PostMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }

    @PostMapping("/createUserWithRandomFields")
    public ResponseEntity<String> createUserWithRandomFields() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://www.random.org/integers/?num=2&min=1&max=6&col=1&base=10&format=plain&rnd=new", String.class);
        String[] str = response.getBody().split("\n");

        User user = new User(22, "user"+str[0]+"@gmail.com", "passw"+str[1], 1);
        userRepository.save(user);

        return ResponseEntity.ok("User created with email and password");
    }

    @ExceptionHandler({InvalidParameterException.class, EmptyParameterException.class})
    public ResponseEntity<String> handleException() {
        return ResponseEntity.status(500).body("Server admin-page-error404.html");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException2() {
        return ResponseEntity.status(500).body("Not valid data!!!");
    }
}
