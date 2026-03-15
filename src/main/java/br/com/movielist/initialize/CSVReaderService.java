package br.com.movielist.initialize;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

@Service
public class CSVReaderService {
	
	private final ResourceLoader resourceLoader;

	public CSVReaderService(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public void readCsvFromResouce() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:/csv/Movielist.csv");
		
		try (Reader reader = new InputStreamReader(resource.getInputStream());
	             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
	            
	            List<String[]> rows = csvReader.readAll();
	            for (String[] row : rows) {
	                System.out.println("Dado: " + row[0]);
	            }
	        } catch (CsvException e) {
				e.printStackTrace();
			}
	}
	

}
