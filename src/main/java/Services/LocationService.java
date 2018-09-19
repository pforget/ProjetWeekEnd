package Services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import DAO.LocationDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Location;

@Path("/locations")
public class LocationService {
	
	LocationDAO dao = new LocationDAO(EntityManagerHelper.getEntityManager());
	
	public LocationService() {
		
	}

	@POST
	public Boolean create(Location l) {
		if (dao.exist(l)) {
			return false;
		}
		return dao.add(l);
	}

	@DELETE
	public Boolean remove(Location l) {
		return dao.delete(l);
	}

	@PUT
	public Boolean update(Location l) {
		return dao.update(l);
	}

	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Location findById(@PathParam("id") int id) {
		return dao.findByID(id);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Location> findAll() {
		return dao.findAll();
	}

}
