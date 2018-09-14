package fr.TAA.ProjetWeekEnd;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Region {	
	
	public Region(String name, List<Department> departments) {
		super();
		this.name = name;
		this.departments = departments;
	}

	public Region() {
		
	}

	private String name;
	
	private List<Department> departments;
	
	@Id
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}
