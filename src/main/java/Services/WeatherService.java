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

import DAO.WeatherDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Weather;

public class WeatherService {

	WeatherDAO dao = new WeatherDAO (EntityManagerHelper.getEntityManager());
	
	@POST
	public Boolean create(Weather w) {
		if (dao.exist(w)) {
			return false;
		}
		return dao.add(w);
	}

	@DELETE
	public Boolean remove(Weather w) {
		return dao.delete(w);
	}

	@PUT
	public Boolean update(Weather w) {
		return dao.update(w);
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Object findById(@PathParam("id") int id) {
		return dao.findByID(id);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Weather> findAll() {
		return dao.findAll();
	}

}
