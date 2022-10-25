package com.kma.demo.service;

import com.kma.demo.entity.Feedback;
import com.kma.demo.entity.Film;
import com.kma.demo.entity.User;
import com.kma.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
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

    public void addFeedbackToFilmById(String userId, String filmId, String grade, String text) {
        try {
            int feedbackGrade = Integer.parseInt(grade);
            if (feedbackGrade < 1 || feedbackGrade > 10) throw new RuntimeException("Invalid grade");
            Film film = filmRepository.findById(Integer.parseInt(filmId)).orElseThrow(() -> new RuntimeException("No film"));
            User user = userRepository.findById(Integer.parseInt(userId)).orElseThrow(() -> new RuntimeException("No user"));
            Feedback feedback = new Feedback(null, film, user, feedbackGrade, text);
            feedbackRepository.save(feedback);
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }

    }
}
