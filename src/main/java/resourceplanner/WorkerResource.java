package resourceplanner;

import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entities.*;

@Path("workers")
public class WorkerResource {
	
	//Get all workers
	//Path: ./workers
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Worker> getWorkers(){
		Database.connect();
		Query q=Database.getEM().createQuery("SELECT w FROM Worker w");
		return q.getResultList();
	}
	
	//Get worker by id
	//Path: ../workers/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Worker getWorkerById(@PathParam("id") int workerId) {
		Database.connect();
		Query q=Database.getEM().createQuery("SELECT w FROM Worker w WHERE w.id="+workerId);
		return (Worker) q.getSingleResult();
	}
	
}
