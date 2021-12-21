package hu.webuni.log.czunyi.dto;

import java.time.LocalDateTime;

//@Entity
public class MileStoneDto {

	//@Id
		//@GeneratedValue
		private Long id;

		private LocalDateTime plannedTime;

		private AddressDto address;

		public MileStoneDto() {
			super();
		}

		public MileStoneDto(Long id, LocalDateTime plannedTime) {
			super();
			this.id = id;
			this.plannedTime = plannedTime;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getPlannedTime() {
			return plannedTime;
		}

		public void setPlannedTime(LocalDateTime plannedTime) {
			this.plannedTime = plannedTime;
		}

		public AddressDto getAddress() {
			return address;
		}

		public void setAddress(AddressDto address) {
			this.address = address;
		}
}
