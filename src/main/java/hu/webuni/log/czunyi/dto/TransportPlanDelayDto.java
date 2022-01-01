package hu.webuni.log.czunyi.dto;

public class TransportPlanDelayDto {

	private Long mileStoneId;
	
	private int delayMin;

	public TransportPlanDelayDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransportPlanDelayDto(Long mileStoneId, int delayMin) {
		super();
		this.mileStoneId = mileStoneId;
		this.delayMin = delayMin;
	}

	public Long getmileStoneId() {
		return mileStoneId;
	}

	public void setmileStoneId(Long mileStoneId) {
		this.mileStoneId = mileStoneId;
	}

	public int getDelayMin() {
		return delayMin;
	}

	public void setDelayMin(int delayMin) {
		this.delayMin = delayMin;
	}
}
