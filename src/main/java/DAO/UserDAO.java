package DAO;

import java.util.List;
import org.hibernate.mapping.Map;
import javax.persistence.EntityManager;

import fr.TAA.ProjetWeekEnd.User;

public class UserDAO implements AbstractDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	EntityManager manager;

	public UserDAO(EntityManager manager) {
		this.manager = manager;
	}

	public long countAll(Map param) {
		String query = "select count (u) from User as u";
		return (long) manager.createQuery(query).getFirstResult();
	}

	public List<Object> findAll() {
		String query = "select u from User as u";
		return manager.createQuery(query).getResultList();
	}

	public User findByID(Object id) {
		int iD = (Integer) id;

		return manager.find(User.class, iD);
	}

	public List<Object> findByName(String name) {
		String query = "select u from User as u where u.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean add(Object o) {
		User u = (User) o;
		
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean delete(Object o) {
		User u = (User) o;

		manager.getTransaction().begin();
		manager.remove(u);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean update(Object o) {
		User u = (User) o;
		
		User uOutOfDate =  findByID(u.getId());	
		
		 if(uOutOfDate != null) {		 
			manager.getTransaction().begin();
			uOutOfDate.setEmail(u.getEmail());
			uOutOfDate.setFavoriteLocations(u.getFavoriteLocations());
			uOutOfDate.setFavoriteSports(u.getFavoriteSports());
			uOutOfDate.setName(u.getName());
			uOutOfDate.setUsername(u.getUsername());
			uOutOfDate.setPassword(u.getPassword());
			manager.getTransaction().commit();
			
			return true;
		 }		
		
		return false;
	}

	public Boolean exist(Object o) {
		return (findByID(((User) o).getId()) != null);
	}

}
