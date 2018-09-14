package fr.TAA.ProjetWeekEnd;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CityPK {
	public CityPK(String name, int postalCode) {
		super();
		this.name = name;
		this.postalCode = postalCode;
	}
	
	public CityPK() {
		
	}

	String name;
	int postalCode;
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}