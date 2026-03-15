package br.com.movielist.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.movielist.dto.ProducerDTO;
import br.com.movielist.dto.ProducersWithMaxMinIntervalDTO;
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
	
	@Override
	public ProducersWithMaxMinIntervalDTO getProducersWithMinAndMaxInterval() {
		List<ProducerDTO> producersWithOrderedInterval = movieListRepository.findProducersWithOrderedInterval();
		ProducersWithMaxMinIntervalDTO producersWithMaxMinIntervalDTO = new ProducersWithMaxMinIntervalDTO();
		
		ProducerDTO procuderWithMinInterval = producersWithOrderedInterval.get(0);
		ProducerDTO producerWithMaxInterval = producersWithOrderedInterval.get(producersWithOrderedInterval.size() - 1);
		
		producersWithOrderedInterval.forEach(producer -> {			
			if (producer.getIntervalYear().equals(procuderWithMinInterval.getIntervalYear())) {
				producersWithMaxMinIntervalDTO.getMin().add(producer);
			}
			
			if (producer.getIntervalYear().equals(producerWithMaxInterval.getIntervalYear())) {
				producersWithMaxMinIntervalDTO.getMax().add(producer);
			}
		});		
		return producersWithMaxMinIntervalDTO;
	}

}
