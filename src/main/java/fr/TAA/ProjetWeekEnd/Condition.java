package fr.TAA.ProjetWeekEnd;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import fr.TAA.ProjetWeekEnd.Weather.Sunshine;

@Entity
public class Condition {
	
	private long id;
	private double minTemperature;
	private double minPluviometry;
	private double minWindCondition;
	private double maxWindCondition;
	private double maxTemperature;
	private double maxPluviometry;
	private ArrayList<Sunshine> toleratedSunshine;
	
	@Id
	public long getId() {
		return id;
	}
	
	public void set(long identifier) {
		this.id = identifier;
	}
	
	public double getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}
	
	public double getMinPluviometry() {
		return minPluviometry;
	}
	public void setMinPluviometry(double minPluviometry) {
		this.minPluviometry = minPluviometry;
	}
	
	public double getMinWindCondition() {
		return minWindCondition;
	}
	public void setMinWindCondition(double minWindCondition) {
		this.minWindCondition = minWindCondition;
	}
	
	public double getMaxWindCondition() {
		return maxWindCondition;
	}
	public void setMaxWindCondition(double maxWindCondition) {
		this.maxWindCondition = maxWindCondition;
	}
	
	public double getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	
	public double getMaxPluviometry() {
		return maxPluviometry;
	}
	public void setMaxPluviometry(double maxPluviometry) {
		this.maxPluviometry = maxPluviometry;
	}
	
	@Column(nullable = false)
	public ArrayList<Sunshine> getToleratedSunshine() {
		return toleratedSunshine;
	}
	public void setToleratedSunshine(ArrayList<Sunshine> toleratedSunshine) {
		this.toleratedSunshine = toleratedSunshine;
	}


}
