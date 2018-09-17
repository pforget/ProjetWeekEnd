package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Location;


public class LocationDAO  implements AbstractDAO {

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

	public List<Object> findAll() {
		String query = "select l from Location as l";
		return manager.createQuery(query).getResultList();
	}

	public Location findByID(long id) {
		return manager.find(Location.class, id);
	}

	public List<Object> findByName(String name) {
		return null;
	}

	public Boolean exist(Object o) {
		return (findByID(((Location) o).getId()) != null);
	}
	public Boolean add(Object o) {
		Location l = (Location) o;
		
		manager.getTransaction().begin();
		manager.persist(l);
		manager.getTransaction().commit();

		return true;
	}
	public Boolean delete(Object o) {
		Location l = (Location) o;

		manager.getTransaction().begin();
		manager.remove(l);
		manager.getTransaction().commit();

		return true;
	}
	
	public Boolean update(Object o) {
		Location l = (Location) o;
		
		Location lOld = findByID(l.getId());
		
		if(lOld != null) {
			manager.getTransaction().begin();
			l.setCity(lOld.getCity());
			l.setDepartment(lOld.getDepartment());
			l.setRegion(lOld.getRegion());
			return true;
		}
		return false;
	}

}
