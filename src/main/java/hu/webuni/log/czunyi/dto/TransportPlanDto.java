package hu.webuni.log.czunyi.dto;

import java.util.List;

public class TransportPlanDto {

		private Long id;

		private double revenue;

		private List<SectionDto> section;

		public TransportPlanDto() {
			super();
		}

		public TransportPlanDto(Long id, double revenue) {
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

		public double getRevenue() {
			return revenue;
		}

		public void setRevenue(double revenue) {
			this.revenue = revenue;
		}

		public List<SectionDto> getSection() {
			return section;
		}

		public void setSection(List<SectionDto> section) {
			this.section = section;
		}
}
