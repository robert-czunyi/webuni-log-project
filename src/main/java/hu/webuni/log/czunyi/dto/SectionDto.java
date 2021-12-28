package hu.webuni.log.czunyi.dto;

import java.util.List;

import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.model.TransportPlan;

public class SectionDto {

	private Long sectionId;

	private String fromMileStone;
	private String toMileStone;
	private Long number;
	
	private List<MileStone> mileStones;
	
	private TransportPlan transportPlan;

	public SectionDto() {
		super();
	}

	public SectionDto(Long sectionId, String fromMileStone, String toMileStone, Long number) {
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
}
