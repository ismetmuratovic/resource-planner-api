package resourceplanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

public class Database {
	public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("resource-planner-api");;
	public static EntityManager em=emf.createEntityManager();;

	public static EntityManager getEM() {
		return em;
	} 
}
