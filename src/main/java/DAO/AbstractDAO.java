package DAO;

import java.util.List;

import org.hibernate.mapping.Map;
import fr.TAA.ProjetWeekEnd.*;

public interface AbstractDAO {
	
	public long countAll(Map param);
	
	public List<Object>findAll();
	
	public Object findByID(Object id);
	
	public List<Object> findByName(String name);
	
	public Boolean exist(Object o);
	
	public Boolean add(Object o);
	
	public Boolean delete(Object o);
	
	public Boolean update(Object o);
		
}
