package hu.webuni.log.czunyi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MileStone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mileStoneId;

	private LocalDateTime plannedTime;

	@ManyToOne
	private Address address;
	
	public MileStone() {
		super();
	}

	public MileStone(Long mileStoneId, LocalDateTime plannedTime) {
		super();
		this.mileStoneId = mileStoneId;
		this.plannedTime = plannedTime;
	}

	public Long getMileStoneId() {
		return mileStoneId;
	}

	public void setMileStoneId(Long mileStoneId) {
		this.mileStoneId = mileStoneId;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
