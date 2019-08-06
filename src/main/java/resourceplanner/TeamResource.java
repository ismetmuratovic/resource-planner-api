package resourceplanner;

import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.*;

@Path("teams")
public class TeamResource {

	//Get all teams
	//Path: ./teams
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Team> getTeams(){
		Database.connect();
		Query q=Database.getEM().createQuery("SELECT t FROM Team t");
		return q.getResultList();
	}
	
	//Get team by id
	//Path: ./teams/{id}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Team getTeamById(@PathParam("id") int teamId) {
		Database.connect();
		Query q=Database.getEM().createQuery("SELECT t FROM Team t WHERE t.id="+teamId);
		return (Team) q.getSingleResult();
	}
}
