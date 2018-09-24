package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Location implements Serializable {
	
	public Location(int id, City city, Department department, Region region) {
		this.id = id;
		this.city = city;
		this.department = department;
		this.region = region;		
	}

	private int id;

	private City city;
	
	private Department department;
	
	private Region region;
	
	private Weather weather;
	
//	private Boolean hasAdequateSport;
	
//	private List<User> users;
	
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

	@ManyToOne
	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

/*	public Boolean getHasAdequateSport() {
		return hasAdequateSport;
	}

	public void setHasAdequateSport(Boolean hasAdequateSport) {
		this.hasAdequateSport = hasAdequateSport;
	}*/

/*	@ManyToMany ( targetEntity=User.class, mappedBy ="favoriteLocations")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/
}

