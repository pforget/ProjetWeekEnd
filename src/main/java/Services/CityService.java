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

import DAO.CityDAO;
import fr.TAA.ProjetWeekEnd.City;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;

@Path("/cities")
public class CityService {
	
	CityDAO dao = new CityDAO(EntityManagerHelper.getEntityManager());
	
	public CityService() {
		
	}

	@POST
	public Boolean create(City c) {
		if (dao.exist(c)) {
			return false;
		}
		return dao.add(c);
	}

	@DELETE
	public Boolean remove(City c) {
		return dao.delete(c);
	}

	@PUT
	public Boolean update(City c) {
		return dao.update(c);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public City findById(String name, int postalCode) {
		return dao.findByID(name, postalCode);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<City> findAll() {
		return dao.findAll();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<City> findByName(String name){
		return dao.findByName(name);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<City> findByPostalCode(int postalCode){
		return dao.findByPostalCode(postalCode);
	}

}
