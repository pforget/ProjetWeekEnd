package Services;

import java.util.List;

public interface InterfaceService {
	
	public Boolean create (Object o);
	public Boolean remove (Object o);
	public Boolean update (Object o);
	public Object findById (Object o);
	public List<Object> findAll ();
}
