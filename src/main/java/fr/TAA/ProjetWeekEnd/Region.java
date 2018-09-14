package fr.TAA.ProjetWeekEnd;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {	

	public Region(String name) {
		this.name = name;
	}
	
	public Region() {
		
	}

	private String name;
	
	@Id
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
