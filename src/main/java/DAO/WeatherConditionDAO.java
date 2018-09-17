package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Condition;
import fr.TAA.ProjetWeekEnd.Weather.Sunshine;

public class WeatherConditionDAO implements AbstractDAO {

	public WeatherConditionDAO(EntityManager manager) {
		this.manager = manager;
	}

	EntityManager manager;
	
	public WeatherConditionDAO() {
		// TODO Auto-generated constructor stub
	}

	public long countAll(Map param) {
		String query = "select count (c) from Condition as c";
		return (long) manager.createQuery(query).getFirstResult();
	}

	public List<Object> findAll() {
		String query = "select c from Condition as c";
		return manager.createQuery(query).getResultList();
	}

	public Condition findByID(Object id) {
		int iD = (Integer) id;

		return manager.find(Condition.class, iD);
	}

	public List<Object> findByName(String name) {
		// Condition doesn't have name
		return null;
	}

	public Boolean exist(Object o) {
		return (findByID(((Condition) o).getId()) != null);
	}

	public Boolean add(Object o) {
		Condition c = (Condition) o;

		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean delete(Object o) {
		Condition c = (Condition) o;

		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean update(Object o) {
		Condition c = (Condition) o;
		
		Condition cOld =  findByID(c.getId());	
		
		 if(cOld != null) {		 
			manager.getTransaction().begin();
			cOld.setMaxTemperature(c.getMaxTemperature());
			cOld.setMinTemperature(c.getMinTemperature());
			cOld.setMaxWindCondition(c.getMaxWindCondition());
			cOld.setMinWindCondition(c.getMinWindCondition());		
			
			cOld.setToleratedSunshine((ArrayList<Sunshine>)  c.getToleratedSunshine().clone());
			manager.getTransaction().commit();
			
			return true;
		 }		
		
		return false;
	}

}
