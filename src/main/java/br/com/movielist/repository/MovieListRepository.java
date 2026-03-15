package br.com.movielist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movielist.entity.MovieList;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, Long> {

}
