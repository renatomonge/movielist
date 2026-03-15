package br.com.movielist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "movielist")
public class MovieList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "studios", nullable = false, length = 100)
	private String studios;

	@Column(name = "producers", nullable = false, length = 150)
	private String producers;

	@Column(name = "produce_year", nullable = false)
	private Integer year;

	@Column(name = "winner", nullable = false)
	private Boolean winner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

}
