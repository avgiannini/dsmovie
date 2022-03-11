package com.meuprojeto.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movie")
public class Score {
	
	@EmbeddedId
	private ScorePk id = new ScorePk();
	private Double value;
	
	public Score() {
		
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public static void setUser(User user) {
		id.setUser(user);
	}

	public ScorePk getId() {
		return id;
	}

	public void setId(ScorePk id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public static void setValue(Double value) {
		this.value = value;
	}

}
