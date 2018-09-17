package DAO;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.City;
import fr.TAA.ProjetWeekEnd.Department;

import java.util.List;

import javax.persistence.EntityManager;


public class DepartmentDAO  implements AbstractDAO {

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

	public Object findByID(Object i) {
		int id = (Integer) i;
		String query = "select d from Department as d where d.id = :id";
		return manager.createQuery(query).setParameter("id", id).getSingleResult();
	}

	public List<Object> findByName(String name) {
		String query = "select d from Department as d where d.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean exist(Object o) {
		Department d = (Department) o;
		return findByID(d.getId()) != null;
	}

	public List<Object> findAll() {
		String query = "select d from Department as d";
		return manager.createQuery(query).getResultList();
	}
	
	public Boolean add(Object o) {
		Department d = (Department) o;
		manager.getTransaction().begin();
		manager.persist(d);
		manager.getTransaction().commit();
		return true;
	}
	
	public Boolean delete(Object o) {
		Department d = (Department) o;
		manager.getTransaction().begin();
		manager.remove(d);
		manager.getTransaction().commit();
		return true;
	}
	
	public Boolean update(Object o) {
		Department d = (Department) o;
		Department dOutOfDate = (Department) findByID(d.getId());
		
		manager.getTransaction().begin();
		dOutOfDate.setName(d.getName());
		dOutOfDate.setCities(d.getCities());
		dOutOfDate.setRegionId(d.getRegionId());
		manager.getTransaction().commit();
		
		return true;
	}

}
