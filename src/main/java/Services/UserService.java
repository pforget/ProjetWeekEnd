package Services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import DAO.UserDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

@Path("/Users")
public class UserService implements InterfaceService{
	
	UserDAO dao = new UserDAO(EntityManagerHelper.getEntityManager());
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@POST
	public Boolean create(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	public Boolean remove(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@PUT
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Object findById(@PathParam("id") Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Object> findAll(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
