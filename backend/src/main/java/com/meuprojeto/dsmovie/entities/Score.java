package com.meuprojeto.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movie")
public class Score {
	
	@EmbeddedId
	private ScorePk id = new ScorePk();
	private Double value;
	
	public Score() {
		
	}
	
	public void setMovie() {
		id.setMovie(movie);
	}
	
	public void setUser() {
		id.setUser(user);
	}

	public Scorepk getId() {
		return id;
	}

	public void setId(Scorepk id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
