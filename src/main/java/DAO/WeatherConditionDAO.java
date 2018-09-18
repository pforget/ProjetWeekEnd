package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Condition;
import fr.TAA.ProjetWeekEnd.Weather.Sunshine;

public class WeatherConditionDAO {

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

	public List<Condition> findAll() {
		String query = "select c from Condition as c";
		return manager.createQuery(query).getResultList();
	}

	public Condition findByID(int id) {
		return manager.find(Condition.class, id);
	}

	public Boolean exist(Condition c) {
		return (findByID(c.getId()) != null);
	}

	public Boolean add(Condition c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean delete(Condition c) {
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();

		return true;
	}

	public Boolean update(Condition c) {		
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
