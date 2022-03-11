package com.meuprojeto.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meuprojeto.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
