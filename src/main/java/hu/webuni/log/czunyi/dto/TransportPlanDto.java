package hu.webuni.log.czunyi.dto;

import java.util.List;

//@Entity
public class TransportPlanDto {

	//@Id
		//@GeneratedValue
		private Long id;

		private int revenue;

		private List<SectionDto> section;

		public TransportPlanDto() {
			super();
		}

		public TransportPlanDto(Long id, int revenue) {
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

		public List<SectionDto> getSection() {
			return section;
		}

		public void setSection(List<SectionDto> section) {
			this.section = section;
		}
}
