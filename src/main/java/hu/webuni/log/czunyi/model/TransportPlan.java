package hu.webuni.log.czunyi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TransportPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double revenue;

	@OneToMany(mappedBy = "transportPlan")
	private List<Section> sections;

	public TransportPlan() {
		super();
	}

	public TransportPlan(Long id, double revenue, List<Section> sections) {
		super();
		this.id = id;
		this.revenue = revenue;
		this.sections = sections;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void addSection(Section section) {
		if (this.sections == null)
			this.sections = new ArrayList<>();

		this.sections.add(section);
		section.setTransportPlan(this);
	}
}
