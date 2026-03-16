package br.com.movielist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProducerDTO {

	@JsonProperty
	private String producer;
	
	@JsonProperty
	private Integer previousWin;
	
	@JsonProperty
	private Integer followingWin;
	
	@JsonProperty("interval")
	private Integer intervalYear;	

	public ProducerDTO(String producer, Integer previousWin, Integer followingWin, Integer intervalYear) {
		this.producer = producer;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
		this.intervalYear = intervalYear;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(Integer previousWin) {
		this.previousWin = previousWin;
	}

	public Integer getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(Integer followingWin) {
		this.followingWin = followingWin;
	}

	public Integer getIntervalYear() {
		return intervalYear;
	}

	public void setIntervalYear(Integer intervalYear) {
		this.intervalYear = intervalYear;
	}

}
