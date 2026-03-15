package br.com.movielist.initialize;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.movielist.service.CSVReaderService;
import br.com.movielist.service.MovieListServiceImpl;

@Component
public class AlimentaBase implements CommandLineRunner {
	
	private final CSVReaderService csvReaderService;
	private final MovieListServiceImpl movieListService;

	public AlimentaBase(CSVReaderService csvReaderService, MovieListServiceImpl movieListService) {
		this.csvReaderService = csvReaderService;
		this.movieListService = movieListService;
	}

	@Override
	public void run(String... args) throws Exception {
		movieListService.saveMovieLists(csvReaderService.readCsvFromResouce());
	}

}
