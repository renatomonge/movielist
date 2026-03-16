package br.com.movielist.initialize;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.movielist.service.MovieListServiceImpl;

@Component
public class MovieListDataImporter implements CommandLineRunner {
	
	private final MovieListServiceImpl movieListService;

	public MovieListDataImporter(MovieListServiceImpl movieListService) {
		this.movieListService = movieListService;
	}

	@Override
	public void run(String... args) throws IOException, Exception  {
		movieListService.importMovieList();
	}

}
