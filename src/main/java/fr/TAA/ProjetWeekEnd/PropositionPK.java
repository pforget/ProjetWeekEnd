package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PropositionPK implements Serializable{
	
	private Sport sport;
	private Location location;
	
	public PropositionPK() {
		
	}

	public PropositionPK(Sport sport, Location location) {
		super();
		this.sport = sport;
		this.location = location;
	}

	@Column(nullable = false)
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Column(nullable = false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
