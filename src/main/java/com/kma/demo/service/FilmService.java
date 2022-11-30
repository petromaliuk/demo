package com.kma.demo.service;

import com.kma.demo.entity.Film;
import com.kma.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
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


    public List<Film> getAll(){
    return  filmRepository.findAll();
    }

    public void save(Film film) {
        filmRepository.save(film);
    }
}
