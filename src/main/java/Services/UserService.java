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
import fr.TAA.ProjetWeekEnd.User;

@Path("/Users")
public class UserService {
	
	UserDAO dao = new UserDAO(EntityManagerHelper.getEntityManager());
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@POST
	public Boolean create(User u) {
		return dao.add(u);
	}

	@DELETE
	public Boolean remove(User u) {
		return dao.delete(u);
	}

	@PUT
	public Boolean update(User u) {
		return dao.update(u);
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public User findById(@PathParam("id") int i) {
		return dao.findByID(i);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> findAll() {
		return dao.findAll();
	}

}
