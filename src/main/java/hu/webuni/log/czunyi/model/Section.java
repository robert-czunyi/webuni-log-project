package hu.webuni.log.czunyi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sectionId;

	@OneToOne
	private MileStone fromMileStone;
	
	@OneToOne
	private MileStone toMileStone;
	
	private Long number;
	
	@ManyToOne
	private TransportPlan transportPlan;

	public Section() {
		super();
	}

	public Section(Long sectionId, Long number) {
		super();
		this.sectionId = sectionId;
		this.number = number;
	}
	
	public Section(Long sectionId, MileStone fromMileStone, MileStone toMileStone, Long number) {
		super();
		this.sectionId = sectionId;
		this.fromMileStone = fromMileStone;
		this.toMileStone = toMileStone;
		this.number = number;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public MileStone getFromMileStone() {
		return fromMileStone;
	}

	public void setFromMileStone(MileStone fromMileStone) {
		this.fromMileStone = fromMileStone;
	}

	public MileStone getToMileStone() {
		return toMileStone;
	}

	public void setToMileStone(MileStone toMileStone) {
		this.toMileStone = toMileStone;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}
}
