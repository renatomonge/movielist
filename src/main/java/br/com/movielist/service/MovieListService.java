package br.com.movielist.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.movielist.entity.MovieList;

@Service
public interface MovieListService {
	
	void saveMovieLists(Set<MovieList> movieLists);
	
}
