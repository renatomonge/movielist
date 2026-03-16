package br.com.movielist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movielist.dto.ProducersWithMaxMinIntervalDTO;
import br.com.movielist.service.MovieListServiceImpl;

@RequestMapping("movielist")
@RestController
public class MovieListController {
	
	private final MovieListServiceImpl movieListService;	

	public MovieListController(MovieListServiceImpl movieListService) {
		this.movieListService = movieListService;
	}

	@GetMapping("producers-min-max-interval")
	public ProducersWithMaxMinIntervalDTO getProducersWithMinMaxInterval() {
		return movieListService.getProducersWithMinAndMaxInterval();
	}
}
