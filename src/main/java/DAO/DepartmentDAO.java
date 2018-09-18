package DAO;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Department;

import java.util.List;

import javax.persistence.EntityManager;


public class DepartmentDAO  {

	public DepartmentDAO() {

	}
	
	EntityManager manager;
	public DepartmentDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public long countAll(Map param) {
		String query = "select count(d) from Department as d";
		return (Long) manager.createQuery(query).getSingleResult();
	}

	public Department findByID(int id) {
		String query = "select d from Department as d where d.id = :id";
		return (Department)manager.createQuery(query).setParameter("id", id).getSingleResult();
	}

	public List<Department> findByName(String name) {
		String query = "select d from Department as d where d.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean exist(Department d) {
		return findByID(d.getId()) != null;
	}

	public List<Department> findAll() {
		String query = "select d from Department as d";
		return manager.createQuery(query).getResultList();
	}
	
	public Boolean add(Department d) {
		manager.getTransaction().begin();
		manager.persist(d);
		manager.getTransaction().commit();
		return true;
	}
	
	public Boolean delete(Department d) {
		manager.getTransaction().begin();
		manager.remove(d);
		manager.getTransaction().commit();
		return true;
	}
	
	public Boolean update(Department d) {
		Department dOutOfDate = (Department) findByID(d.getId());
		
		manager.getTransaction().begin();
		dOutOfDate.setName(d.getName());
		dOutOfDate.setCities(d.getCities());
		dOutOfDate.setRegionId(d.getRegionId());
		manager.getTransaction().commit();
		
		return true;
	}

}
