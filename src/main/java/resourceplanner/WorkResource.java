package resourceplanner;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.*;

@Path("works")
public class WorkResource {
	
	//Get all works
	//Path: ./works
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Work> getWorks(){
		Query q =Database.getEM().createQuery("SELECT w FROM Work w");
		return q.getResultList();
	}
	
	//Get works by worker id
	//Path: ./works/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/worker/{id}")
	public List<Work> getWorkByWorkerId(@PathParam("id") int workerId){
		Query q=Database.getEM().createQuery("SELECT w FROM Work w WHERE w.id.workerId="+workerId);
		return q.getResultList();
	}
	
	//Get works by project id
	//Path: ./works/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/project/{id}")
	public List<Work> getWorkByProjectId(@PathParam("id") int projectId){
		Query q=Database.getEM().createQuery("SELECT w FROM Work w WHERE w.id.projectId="+projectId);
		return q.getResultList();
	}
	
	//Get works for specific team and year
	//Path: ./works/team/{id}/year/{year}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/team/{id}/year/{year}")
	public List<Work> getWorkForTeamAndYear(@PathParam("id") int teamId,@PathParam("year") int year){
		Query q=Database.getEM().createQuery("SELECT w FROM Work w INNER JOIN w.worker.teams t WHERE t.id="+teamId+"AND YEAR(w.id.dateStart)="+year);
		return q.getResultList();
	}
	
	//Put work into database
	//Path: ./works
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String putWork(Work w) {
		Database.getEM().getTransaction().begin();
		Database.getEM().merge(w);
		Database.getEM().getTransaction().commit();
		Database.getEM().close();
		return "OK";
	}
}
