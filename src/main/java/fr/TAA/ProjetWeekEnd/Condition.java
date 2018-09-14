package fr.TAA.ProjetWeekEnd;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Condition {
	
	private long identifier;
	private double minTemperature;
	private double minPluviometry;
	private double minWindCondition;
	private double maxWindCondition;
	private double maxTemperature;
	private double maxPluviometry;
	private List<Sunshine> toleratedSunshine;
	
	@Id
	public long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(long identifier) {
		this.identifier = identifier;
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
	public List<Sunshine> getToleratedSunshine() {
		return toleratedSunshine;
	}
	public void setToleratedSunshine(List<Sunshine> toleratedSunshine) {
		this.toleratedSunshine = toleratedSunshine;
	}


}
