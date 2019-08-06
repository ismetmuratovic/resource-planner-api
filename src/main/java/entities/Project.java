package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="project")
	private List<Work> works;

	public Project() {
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
	@XmlTransient
	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setProject(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setProject(null);

		return work;
	}

}