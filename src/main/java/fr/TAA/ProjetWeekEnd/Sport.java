package fr.TAA.ProjetWeekEnd;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


enum level {Begginer,Advanced,Expert};
@Entity
public class Sport {
	
	public Sport() {
		
	}
	
	public Sport(String name, Long id, boolean needwater, boolean needmountain, Condition weatherCondition) {
		super();
		this.name = name;
		this.id = id;
		this.needwater = needwater;
		this.needmountain = needmountain;
		WeatherCondition = weatherCondition;
	}

	public Sport(String name) {
		this.name = name;
	}

	private String name;
	private Long id;
	private boolean needwater;
	private boolean needmountain;
	private Condition WeatherCondition;
	

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
