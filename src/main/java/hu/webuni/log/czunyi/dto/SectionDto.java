package hu.webuni.log.czunyi.dto;

//@Entity
public class SectionDto {

	//@Id
		//@GeneratedValue
		private Long id;

		private String fromMileStone;
		private String toMileStone;
		private int number;

		public SectionDto() {
			super();
		}

		public SectionDto(Long id, String fromMileStone, String toMileStone, int number) {
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
