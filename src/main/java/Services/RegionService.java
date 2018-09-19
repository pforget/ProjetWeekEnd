package Services;

import java.util.List;

import DAO.RegionDAO;
import fr.TAA.ProjetWeekEnd.EntityManagerHelper;
import fr.TAA.ProjetWeekEnd.Region;

public class RegionService {
	
	RegionDAO dao = new RegionDAO(EntityManagerHelper.getEntityManager());

	public Boolean create(Region r) {
		if (dao.exist(r)) {
			return false;
		}
		return dao.add(r);
	}

	public Boolean remove(Region r) {
		return dao.delete(r);
	}

	public Boolean update(Region r) {
		return dao.update(r);
	}

	public Region findById(String name) {
		return dao.findByID(name);
	}

	public List<Region> findAll() {
		return dao.findAll();
	}

}
