package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.mapping.Selectable;

@Embeddable
public class CityPK implements Serializable {
	public CityPK(String name, int postalCode) {
		super();
		this.name = name;
		this.postalCode = postalCode;
	}
	
	public CityPK() {
		
	}

	private String name;
	private int postalCode;
	
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