package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the works database table.
 * 
 */
@Embeddable
public class WorkPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="worker_id")
	private Long workerId;

	@Column(name="project_id")
	private Long projectId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private java.util.Date dateStart;

	public WorkPK() {
	}
	public Long getWorkerId() {
		return this.workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public Long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public java.util.Date getDateStart() {
		return this.dateStart;
	}
	public void setDateStart(java.util.Date dateStart) {
		this.dateStart = dateStart;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkPK)) {
			return false;
		}
		WorkPK castOther = (WorkPK)other;
		return 
			this.workerId.equals(castOther.workerId)
			&& this.projectId.equals(castOther.projectId)
			&& this.dateStart.equals(castOther.dateStart);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.workerId.hashCode();
		hash = hash * prime + this.projectId.hashCode();
		hash = hash * prime + this.dateStart.hashCode();
		
		return hash;
	}
}