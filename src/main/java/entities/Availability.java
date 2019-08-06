package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the availability database table.
 * 
 */
@Entity
@NamedQuery(name="Availability.findAll", query="SELECT a FROM Availability a")
public class Availability implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvailabilityPK id;

	@Column(name="available_days")
	private Integer availableDays;

	//bi-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="worker_id",insertable=false, updatable=false)
	private Worker worker;

	public Availability() {
	}

	public AvailabilityPK getId() {
		return this.id;
	}

	public void setId(AvailabilityPK id) {
		this.id = id;
	}

	public Integer getAvailableDays() {
		return this.availableDays;
	}

	public void setAvailableDays(Integer availableDays) {
		this.availableDays = availableDays;
	}
	@XmlTransient
	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}