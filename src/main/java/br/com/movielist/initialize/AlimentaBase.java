package br.com.movielist.initialize;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlimentaBase implements CommandLineRunner{
	
	private final CSVReaderService csvReaderService;

	public AlimentaBase(CSVReaderService csvReaderService) {
		this.csvReaderService = csvReaderService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Alimenta base");
		csvReaderService.readCsvFromResouce();
	}

}
