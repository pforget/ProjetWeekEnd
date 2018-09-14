package fr.TAA.ProjetWeekEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Department {

	public Department(int id, String name, Region regionId) {
		this.id = id;
		this.name = name;
		this.regionId = regionId;
	}
	
	public Department() {
		
	}

	private int id;
	
	private String name;
	
	private Region regionId;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Region getRegionId() {
		return regionId;
	}

	public void setRegionId(Region regionId) {
		this.regionId = regionId;
	}
	
}
