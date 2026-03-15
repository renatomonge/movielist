package br.com.movielist.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import br.com.movielist.entity.MovieList;
import br.com.movielist.initialize.MovieListBulder;

@Service
public class CSVReaderService {
	
	private final ResourceLoader resourceLoader;

	public CSVReaderService(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public Set<MovieList> readCsvFromResouce() throws IOException {
		Set<MovieList> movieLists = new HashSet<MovieList>();
		Resource resource = resourceLoader.getResource("classpath:/csv/Movielist.csv");		
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			 String row = null;
			 
			 while ((row = reader.readLine()) != null) {
	            String[] cells = row.split(";");
	            
	            if (cells[0].equals("year")) {
	            	continue;
	            }
	                
	            MovieListBulder movieListBulder = new MovieListBulder()
	                .year(cells[0])
	                .title(cells[1])
	                .studios(cells[2])
	                .producers(cells[3])
	                .winner(cells.length > 4 ? cells[4] : null);	           	            
	            movieLists.add(movieListBulder.build());
			 }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		return movieLists;
	}
	

}
