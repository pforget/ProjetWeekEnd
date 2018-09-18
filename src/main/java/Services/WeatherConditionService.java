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

import DAO.WeatherConditionDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

@Path("/WC")
public class WeatherConditionService implements InterfaceService {

	WeatherConditionDAO dao = new WeatherConditionDAO(EntityManagerHelper.getEntityManager());
	
	@POST
	public Boolean create(Object o) {
		return dao.add(o);
	}

	@DELETE
	public Boolean remove(Object o) {
		return dao.delete(o);
	}

	@PUT
	public Boolean update(Object o) {
		return dao.update(o);
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Object findById(@PathParam("id") Object o) {
		return dao.findByID(o);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Object> findAll() {
		return dao.findAll();
	}

}