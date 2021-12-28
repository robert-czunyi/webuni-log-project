package hu.webuni.log.czunyi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MileStone {

	@Id
	@GeneratedValue
	private Long mileStoneId;

	private LocalDateTime plannedTime;

	@OneToOne
	private Address address;
	
	@ManyToOne
	private Section section;

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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
