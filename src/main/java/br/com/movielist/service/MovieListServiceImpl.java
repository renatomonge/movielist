package br.com.movielist.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.movielist.dto.ProducerDTO;
import br.com.movielist.dto.ProducersWithMaxMinIntervalDTO;
import br.com.movielist.entity.ImportFileControl;
import br.com.movielist.entity.MovieList;
import br.com.movielist.initialize.CsvMovieListReader;
import br.com.movielist.repository.ImportFileControlRepository;
import br.com.movielist.repository.MovieListRepository;
import br.com.movielist.util.HashFileCalculator;

@Service
public class MovieListServiceImpl implements MovieListService {
	
	private final MovieListRepository movieListRepository;
	private final ImportFileControlRepository fileControlRepository;
	private final ResourceLoader resourceLoader;
	
	

	public MovieListServiceImpl(MovieListRepository movieListRepository,
			ImportFileControlRepository fileControlRepository, ResourceLoader resourceLoader) {
		this.movieListRepository = movieListRepository;
		this.fileControlRepository = fileControlRepository;
		this.resourceLoader = resourceLoader;
	}

	@Transactional
	@Override
	public void importMovieList() throws IOException, Exception {
		Resource resource = resourceLoader.getResource("classpath:/csv/Movielist.csv");
		String hash = HashFileCalculator.calcHash(resource.getInputStream());		

		if (!fileControlRepository.existsByHashCode(hash)) {
			CsvMovieListReader csvMovieListReader = new CsvMovieListReader();
			Set<MovieList> movieLists = csvMovieListReader.readCsvFromResouce(resource.getInputStream());		
			
			movieListRepository.deleteAll();
			movieListRepository.saveAll(movieLists);
			fileControlRepository.save(new ImportFileControl(hash, LocalDateTime.now()));
		}
	}
	
	@Override
	public ProducersWithMaxMinIntervalDTO getProducersWithMinAndMaxInterval() {
		List<ProducerDTO> producersWithOrderedInterval = movieListRepository.findProducersWithOrderedInterval();
		ProducersWithMaxMinIntervalDTO producersWithMaxMinIntervalDTO = new ProducersWithMaxMinIntervalDTO();
		
		if (!CollectionUtils.isEmpty(producersWithOrderedInterval)) {
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
		}		
		return producersWithMaxMinIntervalDTO;
	}

}
