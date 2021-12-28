package hu.webuni.log.czunyi.dto;

import java.time.LocalDateTime;

public class MileStoneDto {

		private Long mileStoneId;

		private LocalDateTime plannedTime;

		private AddressDto address;

		public MileStoneDto() {
			super();
		}

		public MileStoneDto(Long mileStoneId, LocalDateTime plannedTime) {
			super();
			this.mileStoneId = mileStoneId;
			this.plannedTime = plannedTime;
		}

		public Long getMileStoneId() {
			return mileStoneId;
		}

		public void setMileStoneId(Long mileStoneId) {
			this.mileStoneId = mileStoneId;
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
