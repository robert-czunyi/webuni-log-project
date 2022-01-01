package hu.webuni.log.czunyi.dto;

import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.model.TransportPlan;

public class SectionDto {

	private Long sectionId;

	private MileStone fromMileStone;
	private MileStone toMileStone;
	private Long number;
	
	private TransportPlan transportPlan;

	public SectionDto() {
		super();
	}

	public SectionDto(Long sectionId, MileStone fromMileStone, MileStone toMileStone, Long number) {
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

	public long getNumber() {
		return number;
	}
	
	public void setNumber(Long number) {
		this.number = number;
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
	
	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}
}
