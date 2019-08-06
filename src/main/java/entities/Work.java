package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;


/**
 * The persistent class for the works database table.
 * 
 */
@Entity
@Table(name="works")
@NamedQuery(name="Work.findAll", query="SELECT w FROM Work w")
public class Work implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private Date dateEnd;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id" ,insertable=false, updatable=false)
	private Project project;

	//bi-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="worker_id" ,insertable=false, updatable=false)
	private Worker worker;

	public Work() {
	}

	public WorkPK getId() {
		return this.id;
	}

	public void setId(WorkPK id) {
		this.id = id;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	@XmlTransient
	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}