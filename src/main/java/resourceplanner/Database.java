package resourceplanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
	public static EntityManagerFactory emf;
	public static EntityManager em;
	
	public static void connect() {
		emf = Persistence.createEntityManagerFactory("resource-planner-api");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEM() {
		return em;
	} 
}
