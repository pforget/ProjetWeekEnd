package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.City;
import fr.TAA.ProjetWeekEnd.Sport;
import fr.TAA.ProjetWeekEnd.SportPK;


public class SportDAO<level> {

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

	public List<Sport> findAll() {
		String query = "select s from Sport as s";
		return manager.createQuery(query).getResultList();

	}

	public Sport findByID(String name, level level) {

		String query = "select s from Sport as s where s.name = :name and s.level = :level";
		return (Sport) manager.createQuery(query)
				.setParameter("name", name)
				.setParameter("level", level)
				.getSingleResult();

	}

	public List<Sport> findByName(String name) {
		String Query = "select s from Sport as s where s.name = :name";
		return manager.createQuery(Query).setParameter("name", name).getResultList();

	}

	public Boolean exist(Sport s) {
		String query = "select count(s) from Sport as s where s.name = :name and s.level = :level";
		return (Long) manager.createQuery(query)
				.setParameter("name", s.getName())
				.setParameter("level", s.getSportPK().getLevel())
				.getSingleResult()
				== 1;

	}
	public Boolean add(Sport s) {
		manager.getTransaction().begin();
		manager.persist(s);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean delete(Sport s) {

		manager.getTransaction().begin();
		manager.remove(s);
		manager.getTransaction().commit();

		return true;
	}
	public Boolean update(Sport s) {

		Sport Sportu =  findByID(s.getName(),(level) s.getSportPK().getLevel());
		if(Sportu != null) {		 
			manager.getTransaction().begin();


			Sportu.setName(s.getName());

			manager.getTransaction().commit();

		}

		return true;
	}
	
}
