package DAO;

import org.hibernate.mapping.Map;
import java.util.List;

import javax.persistence.EntityManager;

import fr.TAA.ProjetWeekEnd.*;

public class CityDAO{

	public CityDAO(EntityManager manager) {
		this.manager = manager;
	}

	public CityDAO() {
	}

	EntityManager manager;
	
	public Long countAll(Map param) {
		String query = "select count(c) from City as c";
		return (Long) manager.createQuery(query).getSingleResult();
	}

	public City findByID(String name, int postalCode) {

		String query = "select c from City as c where c.name = :name and c.postalCode = :postalCode";
		return (City) manager.createQuery(query)
				.setParameter("name", name)
				.setParameter("postalCode", postalCode)
				.getSingleResult();
	}

	public List<City> findByName(String name) {
		String query = "select c from City as c where c.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}
	
	public List<City> findByPostalCode(int postalCode){
		String query = "select c from City as c where c.postalCode = :postalCode";
		return manager.createQuery(query)
				.setParameter("postalCode", postalCode)
				.getResultList();
	}

	public Boolean exist(City c) {
		String query = "select count(c) from City as c where c.name = :name and c.postalCode = :postalCode";
		return (Long) manager.createQuery(query)
				.setParameter("name", c.getName())
				.setParameter("postalCode", c.getPostalCode())
				.getSingleResult()
				== 1;
	}

	public List<City> findAll() {
		String query = "select c from City as c";
		return manager.createQuery(query).getResultList();
	}

	public Boolean add(City c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean delete(City c) {
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean update(City c) {
		City cOutOfDate = findByID(c.getName(), c.getPostalCode());
		
		manager.getTransaction().begin();
		cOutOfDate.setDepartmentID(c.getDepartmentID());
		manager.getTransaction().commit();
		
		return true;
	}

}
