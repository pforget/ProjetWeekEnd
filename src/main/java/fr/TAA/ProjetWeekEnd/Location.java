package fr.TAA.ProjetWeekEnd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Location {
	
	public Location(Long id, City city, Department department, Region region) {
		this.id = id;
		this.city = city;
		this.department = department;
		this.region = region;
	}

	private Long id;
	
	private City city;
	
	private Department department;
	
	private Region region;
	
	public Location() {
		
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}

