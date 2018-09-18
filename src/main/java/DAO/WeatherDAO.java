package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Weather;

public class WeatherDAO {

	public WeatherDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	EntityManager manager;

	public WeatherDAO(EntityManager manager) {
		this.manager = manager;
	}

	public long countAll(Map param) {
		String Query = "select count (w) from Weather as w";
		return (long) manager.createQuery(Query).getFirstResult();

	}

	public List<Weather> findAll() {
		String query = "select w from Weather as w";
		return manager.createQuery(query).getResultList();
	}

	public Weather findByID(int id) {
		// Weather w = (Weather) o;
		return manager.find(Weather.class, id);

	}

	public List<Weather> findByName(String name) {
		String query = "select w from User as w where w.name = :name";
		return manager.createQuery(query).setParameter("name", name).getResultList();

	}

	public Boolean exist(Weather w) {
		return (findByID(w.getId()) != null);
	}

	public Boolean add(Weather w) {
		manager.getTransaction().begin();
		manager.persist(w);
		manager.getTransaction().commit();
		return true;

	}

	public Boolean delete(Weather w) {
		manager.getTransaction().begin();
		manager.remove(w);
		manager.getTransaction().commit();
		return true;
	}

	public Boolean update(Weather w) {

		Weather Weatheru = (Weather) findByID(w.getId());
		if (Weatheru != null) {
			manager.getTransaction().begin();

			Weatheru.setSunshine(w.getSunshine());
			Weatheru.setTemperature(w.getTemperature());
			Weatheru.setWind(w.getWind());

			manager.getTransaction().commit();

		}

		return true;
	}

}
