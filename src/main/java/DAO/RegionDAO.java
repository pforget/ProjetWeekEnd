package DAO;

import java.util.List;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

public class RegionDAO  implements AbstractDAO {

	public RegionDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	EntityManagerHelper manager;
	public RegionDAO(EntityManagerHelper manager) {
		this.manager = manager;
	}
	public long countAll(Map param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean exist(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean add(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
