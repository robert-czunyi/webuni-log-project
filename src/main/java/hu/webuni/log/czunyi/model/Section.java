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
	private Long id;

	private String fromMileStone;
	private String toMileStone;
	private int number;
	
	@OneToMany(mappedBy = "section")
	private List<MileStone> mileStones;
	
	@ManyToOne
	private TransportPlan transportPlan;

	public Section() {
		super();
	}

	public Section(Long id, String fromMileStone, String toMileStone, int number) {
		super();
		this.id = id;
		this.fromMileStone = fromMileStone;
		this.toMileStone = toMileStone;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
