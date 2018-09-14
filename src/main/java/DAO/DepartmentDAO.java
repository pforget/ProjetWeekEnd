package DAO;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

import java.util.List;


public class DepartmentDAO  implements AbstractDAO {

	public DepartmentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	EntityManagerHelper manager;
	public DepartmentDAO(EntityManagerHelper manager) {
		this.manager = manager;
	}
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

}
