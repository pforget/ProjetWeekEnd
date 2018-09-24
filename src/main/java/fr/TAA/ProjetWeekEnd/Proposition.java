package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Proposition implements Serializable {
	
	@EmbeddedId
	private PropositionPK propositionPK;
	
	private boolean available;
	
	public Proposition() {
		
	}

	public Proposition(Sport sport, Location location, boolean available) {
		this.propositionPK = new PropositionPK(sport, location);
		this.available = available;
	}

	public Sport getSport() {
		return propositionPK.getSport();
	}

	public void setSport(Sport sport) {
		propositionPK.setSport(sport);
	}

	public Location getLocation() {
		return propositionPK.getLocation();
	}

	public void setLocation(Location location) {
		propositionPK.setLocation(location);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
