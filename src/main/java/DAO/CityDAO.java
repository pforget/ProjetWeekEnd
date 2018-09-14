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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> findAll() {
		String query = "select c from City as c";
		return manager.createQuery(query).getResultList();
	}

	public Boolean add(City c) {
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean add(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
