package br.com.movielist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.movielist.dto.ProducerDTO;
import br.com.movielist.entity.MovieList;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, Long> {

	@Query(value = 
			  "select "
			+ "    m.producer, "
			+ "    min(m.produce_year) as previousWin, "
			+ "    max(m.produce_year) as followingWin, "
			+ "    max(m.produce_year) - min(m.produce_year) as intervalYear "
			+ "from movielist m "
			+ "where m.winner = true "
			+ "group by m.producer "
			+ "having intervalYear > 0 "
			+ "order by 4 asc", nativeQuery = true)
	List<ProducerDTO> findProducersWithOrderedInterval();

}
