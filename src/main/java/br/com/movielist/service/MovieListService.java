package br.com.movielist.service;

import java.io.IOException;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.movielist.dto.ProducersWithMaxMinIntervalDTO;
import br.com.movielist.entity.MovieList;

@Service
public interface MovieListService {
	
	ProducersWithMaxMinIntervalDTO getProducersWithMinAndMaxInterval();

	void importMovieList() throws IOException, Exception;
	
}
