package fr.TAA.ProjetWeekEnd;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class City {
	
	public void City(String name, int PostalCode, Department departmentID) {
		this.cityPK = new CityPK(name, PostalCode);
		this.departmentID = departmentID;
	}
	
	@EmbeddedId
	private CityPK cityPK;
	
	private Department departmentID;
	
	public void City() {
		
	}
	
}