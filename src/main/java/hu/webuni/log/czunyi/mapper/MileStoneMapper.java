package hu.webuni.log.czunyi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.webuni.log.czunyi.dto.MileStoneDto;
import hu.webuni.log.czunyi.model.MileStone;

@Mapper(componentModel = "spring")
public interface MileStoneMapper {

	MileStoneDto mileStoneToDto(MileStone mileStone);

	MileStone dtoToMileStone(MileStoneDto mileStoneDto);

	List<MileStoneDto> mileStonesToDtos(List<MileStone> mileStones);

	List<MileStone> dtosToMileStones(List<MileStoneDto> MileStoneDtos);
}
