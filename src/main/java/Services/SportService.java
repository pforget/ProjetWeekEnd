package Services;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import DAO.CityDAO;
import fr.TAA.ProjetWeekEnd.City;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Sport;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.CityDAO;
import DAO.SportDAO;
import DAO.UserDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;


@Path("/sports")
public class SportService<level> {
	
	
		
		SportDAO dao = new SportDAO(EntityManagerHelper.getEntityManager());
		
		public SportService() {
			
		}
	@POST
	public Boolean create(Sport s) {
		return dao.add(s);
		
	}
    @DELETE
	public Boolean remove(Sport s) {
    	return dao.delete(s);
	}
    @PUT
	public Boolean update(Sport s) {
    	return dao.update(s);
		
	}
    @GET
    @Produces({MediaType.APPLICATION_JSON})
	public Object findById(String name, level level) {
    	return dao.findByID(name, level);
	
	}

	public List<Sport> findAll() {
		return dao.findAll();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Sport> findByName(String name){
		return dao.findByName(name);
	}
}
