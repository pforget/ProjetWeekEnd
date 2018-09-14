package DAO;

import java.util.List;
import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

public class SportDAO  implements AbstractDAO {

	public SportDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	EntityManagerHelper manager;
	public SportDAO(EntityManagerHelper manager) {
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

}
