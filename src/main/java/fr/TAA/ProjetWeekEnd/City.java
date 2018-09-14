package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable {
	
	public City(String name, int PostalCode, Department departmentID) {
		this.cityPK = new CityPK(name, PostalCode);
		this.departmentID = departmentID;
	}
	
	@EmbeddedId
	private CityPK cityPK;
	
	@ManyToOne
	private Department departmentID;
	
	public City() {
		
	}
	
}