package Services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.DepartmentDAO;
import fr.TAA.ProjetWeekEnd.Department;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

import java.util.List;

@Path("/departments")
public class DepartmentService {
	
	DepartmentDAO dao = new DepartmentDAO(EntityManagerHelper.getEntityManager());

	public DepartmentService() {
		
	}
	
	@POST
	public Boolean create(Department d) {
		return dao.add(d);
	}

	@DELETE
	public Boolean remove(Department d) {
		return dao.delete(d);
	}

	@PUT
	public Boolean update(Department d) {
		return dao.update(d);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Department findById(int id) {
		return dao.findByID(id);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Department> findAll() {
		return dao.findAll();
	}

}
