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

import DAO.PropositionDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Location;
import fr.TAA.ProjetWeekEnd.Proposition;
import fr.TAA.ProjetWeekEnd.Sport;

@Path("/Propositions")
public class PropositionService {

	PropositionDAO dao = new PropositionDAO(EntityManagerHelper.getEntityManager());

	@POST
	public Boolean create(Proposition p) {
		if (dao.exist(p)) {
			return false;
		}
		return dao.add(p);
	}

	@DELETE
	public Boolean remove(Proposition p) {
		return dao.delete(p);
	}

	@PUT
	public Boolean update(Proposition p) {
		return dao.update(p);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Proposition findById(Sport s, Location l) {
		return dao.findByID(s,l);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Proposition> findAll() {
		return dao.findAll();
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	public boolean resetDestination() {
		return dao.ResetDestination();
	}

}
