package hu.webuni.log.czunyi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.webuni.log.czunyi.dto.SectionDto;
import hu.webuni.log.czunyi.model.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {

	SectionDto sectionToDto(Section section);

	Section dtoToSection(SectionDto sectionDto);

	List<SectionDto> sectionsToDtos(List<Section> sections);

	List<Section> dtosToSections(List<SectionDto> sectionDtos);
}
