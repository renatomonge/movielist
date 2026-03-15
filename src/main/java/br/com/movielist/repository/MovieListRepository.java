package br.com.movielist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.movielist.entity.MovieList;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {

}
