package DAO;

import java.util.List;
import org.hibernate.mapping.Map;
import javax.persistence.EntityManager;

import fr.TAA.ProjetWeekEnd.Location;
import fr.TAA.ProjetWeekEnd.Sport;
import fr.TAA.ProjetWeekEnd.User;

public class UserDAO {

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

	public List<User> findAll() {
		String query = "select u from User as u";
		return manager.createQuery(query).getResultList();
	}

	public User findByID(int id) {

		return manager.find(User.class, id);
	}

	public List<User> findByName(String name) {
		String query = "select u from User as u where u.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();
	}

	public Boolean add(User u) {
	
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean delete(User u) {

		manager.getTransaction().begin();
		manager.remove(u);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean update(User u) {		
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

	public Boolean exist(User u) {
		return (findByID(u.getId()) != null);
	}
	
	public List<Location> getFavoriteLocations(User u){
		String query = "select u.Location from Location as l where u = :user"
				+ "join fetch l.Weather from Weather";
		return manager.createQuery(query).setParameter("user", u).getResultList();
	}
	
	public List<Sport> getFavoriteSports(User u){
		String query = "select u.Sport from Sport as s where u = :user"
				+ "join fetch s.WeatherCondition from WeatherCondition";
		return manager.createQuery(query).setParameter("user", u).getResultList();
	}

}
