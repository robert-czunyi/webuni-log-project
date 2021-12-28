package hu.webuni.log.czunyi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section {

	@Id
	@GeneratedValue
	private Long sectionId;

	private String fromMileStone;
	private String toMileStone;
	private Long number;
	
	@OneToMany(mappedBy = "section")
	private List<MileStone> mileStones;

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
	
	public Section(Long sectionId, String fromMileStone, String toMileStone, Long number) {
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

	public String getFromMileStone() {
		return fromMileStone;
	}

	public void setFromMileStone(String fromMileStone) {
		this.fromMileStone = fromMileStone;
	}

	public String getToMileStone() {
		return toMileStone;
	}

	public void setToMileStone(String toMileStone) {
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

	public List<MileStone> getMileStones() {
		return mileStones;
	}

	public void setMileStones(List<MileStone> mileStones) {
		this.mileStones = mileStones;
	}
}
