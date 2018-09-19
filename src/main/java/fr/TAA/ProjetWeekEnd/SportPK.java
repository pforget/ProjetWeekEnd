package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SportPK implements Serializable{
	
	private String name;
	private level level;
	
	public SportPK() {
		
	}
	
	public SportPK(String name, level level) {
		super();
		this.name = name;
		this.level = level;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public level getLevel() {
		return level;
	}

	public void setLevel(level level) {
		this.level = level;
	}

}
