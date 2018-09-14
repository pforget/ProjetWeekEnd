package DAO;

import org.hibernate.mapping.Map;
import java.util.List;
import fr.TAA.ProjetWeekEnd.*;

public class CityDAO implements AbstractDAO{

	public CityDAO(EntityManagerHelper manager) {
		this.manager = manager;
	}

	public CityDAO() {
	}

	EntityManagerHelper manager;
	
	public long countAll(Map param) {
		// TODO Auto-generated method stub
		return 0;
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

	public List<Object> findAll() {
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
