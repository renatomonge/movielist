package br.com.movielist.entity.builder;

import java.time.LocalDateTime;

import br.com.movielist.entity.MovieList;

public class MovieListBulder {

	private int year;
	private String title;
	private String studios;
	private String producers;
	private boolean winner;
	
	public MovieListBulder year(String year) {
		if (year != null && !year.isBlank()) {
			this.year = Integer.valueOf(year.trim());
		}
		return this;
	}
	
	public MovieListBulder title(String title) {
		if (title != null && !title.isBlank()) {
			this.title = title.trim();
		}
		return this;
	}
	
	public MovieListBulder studios(String studios) {
		if (studios != null && !studios.isBlank()) {
			this.studios = studios.trim();
		}
		return this;
	}
	
	public MovieListBulder producers(String producers) {
		if (producers != null && !producers.isBlank()) {
			this.producers = producers.trim();
		}
		return this;
	}
	
	public MovieListBulder winner(String winner) {
		this.winner = false;

		if (winner != null && !winner.isBlank()) {
			this.winner = winner.trim().equalsIgnoreCase("yes");
		}
		return this;
	}
	
	public MovieList build() {
		MovieList movieList = new MovieList();
		
		movieList.setYear(year);
		movieList.setTitle(title);
		movieList.setProducers(producers);
		movieList.setStudios(studios);
		movieList.setWinner(winner);
		movieList.setCreatedDate(LocalDateTime.now());
		return movieList;
	}
	
}
