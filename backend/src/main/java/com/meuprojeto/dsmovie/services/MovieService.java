package com.meuprojeto.dsmovie.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meuprojeto.dsmovie.dto.MovieDTO;
import com.meuprojeto.dsmovie.entities.Movie;
import com.meuprojeto.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findALL(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(listing -> new MovieDTO(listing));
		return page;
	}
	
	public MovieDTO findById(Long id) {
		Movie result = movieRepository.findById(id).get();
		MovieDTO moviedto = new MovieDTO(result);
		return moviedto;
	}
	
}
