package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import java.util.List;


/**
 * The persistent class for the worker database table.
 * 
 */
@Entity
@NamedQuery(name="Worker.findAll", query="SELECT w FROM Worker w")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Availability
	@OneToMany(mappedBy="worker")
	private List<Availability> availabilities;

	//bi-directional many-to-many association to Team
	@ManyToMany
	@JoinTable(
		name="belongs"
		, joinColumns={
			@JoinColumn(name="worker_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="team_id")
			}
		)
	@XmlInverseReference(mappedBy="workers")
	private List<Team> teams;

	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="worker")
	private List<Work> works;

	public Worker() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlTransient 
	public List<Availability> getAvailabilities() {
		return this.availabilities;
	}

	public void setAvailabilities(List<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public Availability addAvailability(Availability availability) {
		getAvailabilities().add(availability);
		availability.setWorker(this);

		return availability;
	}

	public Availability removeAvailability(Availability availability) {
		getAvailabilities().remove(availability);
		availability.setWorker(null);

		return availability;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	@XmlTransient 
	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setWorker(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setWorker(null);

		return work;
	}

}