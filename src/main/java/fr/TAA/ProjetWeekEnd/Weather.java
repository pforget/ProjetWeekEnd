package fr.TAA.ProjetWeekEnd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weather {
	

public enum Sunshine {

	FortementEnsoleillé,
	Ensoleillé,
	NuageuxAvecEclaircissement,
	FortementNuageux,
	Pluvieux,
	Neige,
	Grêle,
	Gel; 

}
	
	public Weather() {
		
	}
	
	public Weather(Long id, float temperature, float wind, Sunshine sunshine) {
		this.id = id;
		this.temperature = temperature;
		this.wind = wind;
		this.sunshine = sunshine;
	}

	private Long id;

	private float temperature;
	
	private float wind;
	
	private Sunshine sunshine;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWind() {
		return wind;
	}

	public void setWind(float wind) {
		this.wind = wind;
	}

	public Sunshine getSunshine() {
		return sunshine;
	}

	public void setSunshine(Sunshine sunshine) {
		this.sunshine = sunshine;
	}
	
}

