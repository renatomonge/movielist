package br.com.movielist.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import br.com.movielist.entity.MovieList;
import br.com.movielist.entity.builder.MovieListBulder;

public class CsvMovieListReader {
	
	private static final int YEAR = 0;
	private static final int TITLE = 1;
	private static final int STUDIOS = 2;
	private static final int PRODUCERS = 3;
	private static final int WINNER = 4;
	
	public Set<MovieList> readCsvFromResouce(InputStream inputStream) throws IOException {
		Set<MovieList> movieLists = new HashSet<MovieList>();	
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			 String row = null;
			 
			 while ((row = reader.readLine()) != null) {
	            String[] cells = row.split(";");
	            
	            if (cells[0].equals("year")) {
	            	continue;
	            }
	            
	            String[] producers = cells[PRODUCERS].split(",");
	            
	            for (String producer : producers) {
	            	MovieListBulder movieListBulder = new MovieListBulder()
	    	                .year(cells[YEAR])
	    	                .title(cells[TITLE])
	    	                .studios(cells[STUDIOS])
	    	                .producer(producer)
	    	                .winner(cells.length > 4 ? cells[WINNER] : null);	           	            
	    	            movieLists.add(movieListBulder.build());
	            }	               	            
			 }
	    } catch (IOException e) {
	    	throw new RuntimeException("Erro ao importar csv: " + e.getMessage());
	    }
		return movieLists;
	}
}
