package fr.TAA.ProjetWeekEnd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Location {
	
	public Location(int id, City city, Department department, Region region, Boolean hasWater,
			Boolean hasMontagne) {
		super();
		this.id = id;
		this.city = city;
		this.department = department;
		this.region = region;
		this.hasWater = hasWater;
		this.hasMontagne = hasMontagne;
	}

	private int id;
	
	private City city;
	
	private Department department;
	
	private Region region;
	
	private Weather weather;
	
	private Boolean hasWater;
	
	private Boolean hasMontagne;
	
	public Location() {
		
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@OneToMany
	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Boolean getHasWater() {
		return hasWater;
	}

	public void setHasWater(Boolean hasWater) {
		this.hasWater = hasWater;
	}

	public Boolean getHasMontagne() {
		return hasMontagne;
	}

	public void setHasMontagne(Boolean hasMontagne) {
		this.hasMontagne = hasMontagne;
	}
}

