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

@Path("availabilities")
public class AvailabilityResource {

	//Get all availabilities
	//Path: ./availabilities
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Availability> getAvailabilities(){
		Query q=Database.getEM().createQuery("SELECT a FROM Availability a");
		return q.getResultList();
	}
	
	//Get all availabilities fro specific team and year
	//Path: ./availabilities/team/{id}/year/{year}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/team/{id}/year/{year}")
	public List<Availability> getAvailabilitiesForTeamAndYear(@PathParam("id") int teamId,@PathParam("year") int year){
		Query q=Database.getEM().createQuery("SELECT a FROM Availability a INNER JOIN a.worker.teams t WHERE t.id="+teamId+"AND YEAR(a.id.week)="+year);
		return q.getResultList();
	}
	
	//Put availability into database
	//Path: ./availabilities
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String putAvailability(Availability a) {
		Database.getEM().getTransaction().begin();
		Database.getEM().merge(a);
		Database.getEM().getTransaction().commit();
		return "OK";
	}
	
}
