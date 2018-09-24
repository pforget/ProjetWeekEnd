package Services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.RegionDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Region;

@Path("Regions")
public class RegionService {
	
	RegionDAO dao = new RegionDAO(EntityManagerHelper.getEntityManager());

	@POST
	public Boolean create(Region r) {
		if (dao.exist(r)) {
			return false;
		}
		return dao.add(r);
	}

	@DELETE
	public Boolean remove(Region r) {
		return dao.delete(r);
	}

	@PUT
	public Boolean update(Region r) {
		return dao.update(r);
	}

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Region findById(@PathParam("id") String name) {
		return dao.findByID(name);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Region> findAll() {
		return dao.findAll();
	}

}
