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
import fr.TAA.ProjetWeekEnd.Condition;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

@Path("/WC")
public class WeatherConditionService {

	WeatherConditionDAO dao = new WeatherConditionDAO(EntityManagerHelper.getEntityManager());
	
	@POST
	public Boolean create(Condition c) {
		return dao.add(c);
	}

	@DELETE
	public Boolean remove(Condition o) {
		return dao.delete(o);
	}

	@PUT
	public Boolean update(Condition o) {
		return dao.update(o);
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Object findById(@PathParam("id") int i) {
		return dao.findByID(i);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Condition> findAll() {
		return dao.findAll();
	}

}
