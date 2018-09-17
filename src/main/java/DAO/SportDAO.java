package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.mapping.Map;


import fr.TAA.ProjetWeekEnd.Sport;
import fr.TAA.ProjetWeekEnd.User;

public class SportDAO  implements AbstractDAO {

	public SportDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	EntityManager manager;
	public SportDAO(EntityManager manager) {
		this.manager = manager;
	}
	public long countAll(Map param) {
		String Query= "select count (s) from Sport as s";
		return (long) manager.createQuery(Query).getFirstResult();
	}

	public List<Object> findAll() {
		String query = "select s from Sport as s";
		return manager.createQuery(query).getResultList();
		
	}

	public Sport findByID(long id) {
		return manager.find(Sport.class, id);
		
	}

	public List<Object> findByName(String name) {
		String Query = "select s from Sport as s where s.name = :name";
		return manager.createQuery(Query).setParameter("name", name).getResultList();
		
	}

	public Boolean exist(Object o) {
		return (findByID(((Sport) o).getId()) != null);
		
	}
	public Boolean add(Object o) {
		Sport s = (Sport) o;

		manager.getTransaction().begin();
		manager.persist(s);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean delete(Object o) {
		Sport s = (Sport) o;

		manager.getTransaction().begin();
		manager.remove(s);
		manager.getTransaction().commit();

		return true;
	}
	public Boolean update(Object o) {
		Sport s = (Sport) o;
		
		Sport Sportu =  findByID(s.getId());
		if(Sportu != null) {		 
			manager.getTransaction().begin();
			
			Sportu.setLocations(s.getLocations());
			Sportu.setName(s.getName());
			
			manager.getTransaction().commit();
		
	}
	
		return true;
	
	
}
}
