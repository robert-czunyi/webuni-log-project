package hu.webuni.log.czunyi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.webuni.log.czunyi.dto.TransportPlanDto;
import hu.webuni.log.czunyi.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	TransportPlanDto transportPlanToDto (TransportPlan transportPlan);
	
	TransportPlan dtoToTransportPlan(TransportPlanDto transportPlanDto);
	
	List<TransportPlanDto> transportPlansToDtos (List<TransportPlan> transportPlans);
	
	List<TransportPlan> dtosToTransportPlans(List<TransportPlanDto> transportPlanDtos);
}
