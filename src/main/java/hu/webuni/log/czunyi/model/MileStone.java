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
	private Long id;

	private LocalDateTime plannedTime;

	@OneToOne
	private Address address;
	
	@ManyToOne
	private Section section;

	public MileStone() {
		super();
	}

	public MileStone(Long id, LocalDateTime plannedTime) {
		super();
		this.id = id;
		this.plannedTime = plannedTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
