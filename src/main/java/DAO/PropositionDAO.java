package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.mapping.Map;

import fr.TAA.ProjetWeekEnd.Location;
import fr.TAA.ProjetWeekEnd.Proposition;
import fr.TAA.ProjetWeekEnd.Sport;

public class PropositionDAO {

    public PropositionDAO() {
        // TODO Auto-generated constructor stub
    }

    EntityManager manager;

    public PropositionDAO(EntityManager manager) {
        this.manager = manager;
    }

    public long countAll(Map param) {
        String query = "select count (p) from Proposition as p";
        return (long) manager.createQuery(query).getFirstResult();
    }

    public List<Proposition> findAll() {
        String query = "select p from Proposition as p";
        return manager.createQuery(query).getResultList();
    }

    public Proposition findByID(Sport s, Location l) {

        String query = "select p from Proposition as p where p.sport = :sport and p.location = :location";
        return (Proposition) manager.createQuery(query)
                .setParameter("sport", s)
                .setParameter("location", l)
                .getSingleResult();
    }

    public Boolean add(Proposition p) {
    
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();

        return true;
    }

    public Boolean delete(Proposition p) {

        manager.getTransaction().begin();
        manager.remove(p);
        manager.getTransaction().commit();

        return true;
    }

    public Boolean update(Proposition p) {        
        Proposition pOutOfDate =  findByID(p.getSport(), p.getLocation());    
        
         if(pOutOfDate != null) {        
            manager.getTransaction().begin();
            p.setAvailable(pOutOfDate.isAvailable());
            manager.getTransaction().commit();
            
            return true;
         }        
        
        return false;
    }

    public Boolean exist(Proposition p) {
        return (findByID(p.getSport(), p.getLocation()) != null);
    }
    
    public Boolean ResetDestination() {
        List<Proposition> allProposition = findAll();
        manager.getTransaction().begin();
        for(int i=0; i<allProposition.size(); ++i) {
            Proposition p = allProposition.get(i);
            p.setAvailable(false);
        }
        manager.getTransaction().commit();
        return true;
    }
}