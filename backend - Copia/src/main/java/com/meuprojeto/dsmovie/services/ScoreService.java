package com.meuprojeto.dsmovie.services;

import com.meuprojeto.dsmovie.dto.MovieDTO;
import com.meuprojeto.dsmovie.dto.ScoreDTO;
import com.meuprojeto.dsmovie.entities.Movie;
import com.meuprojeto.dsmovie.entities.Score;
import com.meuprojeto.dsmovie.entities.User;
import com.meuprojeto.dsmovie.repositories.MovieRepository;
import com.meuprojeto.dsmovie.repositories.ScoreRepository;
import com.meuprojeto.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).orElse(null);

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());
        scoreRepository.saveAndFlush(score);

        double sum = 0.0;

        if (Objects.nonNull(movie)) {
            for (Score added : movie.getScores()) {
                sum = sum + added.getValue();
            }

            double avg = sum / movie.getScores().size();
            movie.setScore(avg);
            movie.setCount(movie.getScores().size());

            movie = movieRepository.save(movie);

            return new MovieDTO(movie);
        }

        return null;

    }

}
