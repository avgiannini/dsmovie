package com.meuprojeto.dsmovie.repositories;

import com.meuprojeto.dsmovie.entities.Score;
import com.meuprojeto.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
