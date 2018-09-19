package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Location;


public class LocationDAO  {

	public LocationDAO() {
		// TODO Auto-generated constructor stub
	}
	
	EntityManager manager;
	public LocationDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public long countAll(Map param) {
		String query = "select count (l) from Location as l";
		return (long) manager.createQuery(query).getFirstResult();
	}

	public List<Location> findAll() {
		String query = "select l from Location as l";
		return manager.createQuery(query).getResultList();
	}

	public Location findByID(int id) {
	
		return manager.find(Location.class, id);
	}

	public Boolean exist(Location l) {
		return (findByID(l.getId()) != null);
	}
	
	public Boolean add(Location l) {
	
		manager.getTransaction().begin();
		manager.persist(l);
		manager.getTransaction().commit();

		return true;
	}
	
	public Boolean delete(Location l) {

		manager.getTransaction().begin();
		manager.remove(l);
		manager.getTransaction().commit();

		return true;
	}
	
	public Boolean update(Location l) {
		
		Location lOld = findByID(l.getId());
		
		if(lOld != null) {
			manager.getTransaction().begin();
			l.setCity(lOld.getCity());
			l.setDepartment(lOld.getDepartment());
			l.setRegion(lOld.getRegion());
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
