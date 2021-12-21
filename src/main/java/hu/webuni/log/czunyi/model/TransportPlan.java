package hu.webuni.log.czunyi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TransportPlan {

	@Id
	@GeneratedValue
	private Long id;

	private int revenue;

	@OneToMany(mappedBy = "transportPlan")
	private List<Section> section;

	public TransportPlan() {
		super();
	}

	public TransportPlan(Long id, int revenue) {
		super();
		this.id = id;
		this.revenue = revenue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}
}
