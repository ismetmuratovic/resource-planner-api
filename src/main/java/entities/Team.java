package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-many association to Worker
	@ManyToMany(mappedBy="teams")
	@XmlTransient
	private List<Worker> workers;

	public Team() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Worker> getWorkers() {
		return this.workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

}