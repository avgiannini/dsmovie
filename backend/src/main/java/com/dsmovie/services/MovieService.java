package com.dsmovie.services;

import com.dsmovie.dto.MovieDTO;
import com.dsmovie.entities.Movie;
import com.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(MovieDTO::new);
    }

    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);

        if (Objects.nonNull(movie)) {
            return new MovieDTO(movie);
        }

        return null;
    }

}
