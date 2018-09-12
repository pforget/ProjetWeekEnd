package fr.TAA.ProjetWeekEnd;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class City {
	
	public void City(String name, int PostalCode) {
		this.cityPK = new CityPK(name, PostalCode);
	}
	
	@EmbeddedId
	private CityPK cityPK;
	
	public void City() {
		
	}
	
}