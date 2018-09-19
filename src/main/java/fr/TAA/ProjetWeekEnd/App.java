package fr.TAA.ProjetWeekEnd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            
            Location l = new Location();
            manager.persist(l);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        
        manager.close();
        factory.close();

    	
    	/*EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            
            Employee e = new Employee();
            e.setName("toto");
            manager.persist(e);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        
        manager.close();
        factory.close();
*/
    }
}
