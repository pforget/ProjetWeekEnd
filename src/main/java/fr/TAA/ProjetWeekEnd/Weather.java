package fr.TAA.ProjetWeekEnd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weather {
	
	public Weather() {
		
	}
	
	public Weather(Long id, Temperature temperature, Wind wind, Sunshine sunshine) {
		this.id = id;
		this.temperature = temperature;
		this.wind = wind;
		this.sunshine = sunshine;
	}

	private Long id;

	private Temperature temperature;
	
	private Wind wind;
	
	private Sunshine sunshine;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Sunshine getSunshine() {
		return sunshine;
	}

	public void setSunshine(Sunshine sunshine) {
		this.sunshine = sunshine;
	}
	
}
