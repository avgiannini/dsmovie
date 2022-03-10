package com.meuprojeto.dsmovie.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;

@Embeddable
public class ScorePk {
	
	@ManyToOne
	@MapKeyJoinColumn(name = "movie-id")
	private Movie movie;
	
	@ManyToOne
	@MapKeyJoinColumn(name = "user-id")
	private User user;
	
	public ScorePk() {
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
