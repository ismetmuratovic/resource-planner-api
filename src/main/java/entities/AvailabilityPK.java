package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the availability database table.
 * 
 */
@Embeddable
public class AvailabilityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="worker_id")
	private Long workerId;

	@Temporal(TemporalType.DATE)
	private java.util.Date week;

	public AvailabilityPK() {
	}
	public Long getWorkerId() {
		return this.workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public java.util.Date getWeek() {
		return this.week;
	}
	public void setWeek(java.util.Date week) {
		this.week = week;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvailabilityPK)) {
			return false;
		}
		AvailabilityPK castOther = (AvailabilityPK)other;
		return 
			this.workerId.equals(castOther.workerId)
			&& this.week.equals(castOther.week);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.workerId.hashCode();
		hash = hash * prime + this.week.hashCode();
		
		return hash;
	}
}