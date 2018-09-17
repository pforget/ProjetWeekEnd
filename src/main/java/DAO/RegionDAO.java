package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Department;
import fr.TAA.ProjetWeekEnd.Region;

public class RegionDAO  implements AbstractDAO {

	public RegionDAO() {

	}
	
	EntityManager manager;
	public RegionDAO(EntityManager manager) {
		this.manager = manager;
	}
	public long countAll(Map param) {
		String query = "select count(r) from Region as r";
		return (Long) manager.createQuery(query).getSingleResult();
	}

	public List<Object> findAll() {
		String query = "select r from Region as r";
		return manager.createQuery(query).getResultList();
	}

	public Object findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> findByName(String name) {
		String query = "select r from Region as r where r.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean exist(Object o) {
		Region r = (Region) o;
		return findByName(r.getName()) != null;
	}
	public Boolean add(Object o) {
		Region r = (Region) o;
		manager.getTransaction().begin();
		manager.persist(r);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean delete(Object o) {
		Region r = (Region) o;
		manager.getTransaction().begin();
		manager.remove(r);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean update(Object o) {
		Region r = (Region) o;
		Region rOutOfDate = (Region) findByName(r.getName());
		
		manager.getTransaction().begin();
		rOutOfDate.setDepartments(r.getDepartments());;
		manager.getTransaction().commit();
		
		return true;
	}

}
