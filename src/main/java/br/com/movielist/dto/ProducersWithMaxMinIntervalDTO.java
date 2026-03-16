package br.com.movielist.dto;

import java.util.ArrayList;
import java.util.List;

public class ProducersWithMaxMinIntervalDTO {

	private List<ProducerDTO> min;
	private List<ProducerDTO> max;
	
	public ProducersWithMaxMinIntervalDTO() {
		this.min = new ArrayList<>();
		this.max = new ArrayList<>();
	}

	public List<ProducerDTO> getMin() {
		return min;
	}

	public void setMin(List<ProducerDTO> min) {
		this.min = min;
	}

	public List<ProducerDTO> getMax() {
		return max;
	}

	public void setMax(List<ProducerDTO> max) {
		this.max = max;
	}

}
