package br.com.movielist.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.movielist.entity.MovieList;
import br.com.movielist.repository.MovieListRepository;

@Service
public class MovieListServiceImpl implements MovieListService {
	
	private final MovieListRepository movieListRepository;
	
	public MovieListServiceImpl(MovieListRepository movieListRepository) {
		this.movieListRepository = movieListRepository;
	}

	@Override
	public void saveMovieLists(Set<MovieList> movieLists) {
		movieListRepository.saveAll(movieLists);
	}

}
