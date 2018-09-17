package DAO;

import org.hibernate.mapping.Map;
import java.util.List;

import javax.persistence.EntityManager;

import fr.TAA.ProjetWeekEnd.*;

public class CityDAO implements AbstractDAO{

	public CityDAO(EntityManager manager) {
		this.manager = manager;
	}

	public CityDAO() {
	}

	EntityManager manager;
	
	public long countAll(Map param) {
		String query = "select count(c) from City as c";
		return (Long) manager.createQuery(query).getSingleResult();
	}

	public Object findCity(String name, int postalCode) {
		String query = "select c from City where c.name = :name and c.postalCode = :postalCode";
		return (City) manager.createQuery(query)
				.setParameter("name", name)
				.setParameter("postalCode", postalCode)
				.getSingleResult();
	}

	public List<Object> findByName(String name) {
		String query = "select c from City where c.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean exist(Object o) {
		City city = (City) o;
		String cityName = city.getName();
		int postalCode = city.getPostalCode();
		String query = "select count(c) from City where c.name = :name and c.postalCode = :postalCode";
		return (Long) manager.createQuery(query)
				.setParameter("name", cityName)
				.setParameter("postalCode", postalCode)
				.getSingleResult()
				== 1;
	}

	public List<Object> findAll() {
		String query = "select c from City as c";
		return manager.createQuery(query).getResultList();
	}

	public Boolean add(Object o) {
		City c = (City) o;
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean delete(Object o) {
		City c = (City) o;
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean update(Object o) {
		
		City c = (City) o;
		
		City cOutOfDate = (City) findCity(c.getName(), c.getPostalCode());
		
		manager.getTransaction().begin();
		cOutOfDate.setDepartmentID(c.getDepartmentID());
		manager.getTransaction().commit();
				
		return true;
	}

	// Garde-t-on findByID dans AbstractDAO ?
	public Object findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
