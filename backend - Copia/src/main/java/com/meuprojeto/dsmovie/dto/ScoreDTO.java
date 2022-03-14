package com.meuprojeto.dsmovie.dto;

public class ScoreDTO {

    private Long movieId;
    private String email;
    private Double score;

    public ScoreDTO() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public String getEmail() {
        return email;
    }

    public Double getScore() {
        return score;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
