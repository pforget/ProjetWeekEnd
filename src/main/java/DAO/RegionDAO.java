package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Region;

public class RegionDAO {

	public RegionDAO() {

	}
	
	EntityManager manager;
	public RegionDAO(EntityManager manager) {
		this.manager = manager;
	}
	public long countAll(Map param) {
		String query = "select count(r) from Region as r";
		return (Long) manager.createQuery(query).getSingleResult();
	}

	public List<Region> findAll() {
		String query = "select r from Region as r";
		return manager.createQuery(query).getResultList();
	}

	public Object findByID(String id) {		
		String query = "select r from Region as r where r.name = :name";
		return manager.createQuery(query).setParameter("name", id).getFirstResult();
	}


	public Boolean exist(Region r) {
		return findByID(r.getName()) != null;
	}
	public Boolean add(Region r) {
		manager.getTransaction().begin();
		manager.persist(r);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean delete(Region r) {
		manager.getTransaction().begin();
		manager.remove(r);
		manager.getTransaction().commit();
		return true;
	}
	public Boolean update(Region r) {
		Region rOutOfDate = (Region) findByID(r.getName());
		
		manager.getTransaction().begin();
		rOutOfDate.setDepartments(r.getDepartments());;
		manager.getTransaction().commit();
		
		return true;
	}

}
