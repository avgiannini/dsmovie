package com.dsmovie.services;

import com.dsmovie.dto.MovieDTO;
import com.dsmovie.dto.ScoreDTO;
import com.dsmovie.entities.Movie;
import com.dsmovie.entities.Score;
import com.dsmovie.entities.User;
import com.dsmovie.repositories.MovieRepository;
import com.dsmovie.repositories.ScoreRepository;
import com.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ScoreService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(UserRepository userRepository,
                        MovieRepository movieRepository,
                        ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail()).orElse(null);

        if (Objects.nonNull(user)) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).orElse(null);

        if (Objects.nonNull(movie)) {
            Score score = new Score();
            score.setMovie(movie);
            score.setUser(user);
            score.setValue(score.getValue());

            scoreRepository.saveAndFlush(score);

            double sum = 0.0;
            for (Score s : movie.getScores()) {
                sum = sum + s.getValue();
            }

            double average = sum / movie.getScores().size();
            movie.setScore(average);
            movie.setCount(movie.getScores().size());

            movie = movieRepository.save(movie);

            return new MovieDTO(movie);
        }

        return null;
    }

}
