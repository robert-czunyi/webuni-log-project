package hu.webuni.log.czunyi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.log.czunyi.dto.MileStoneDto;
import hu.webuni.log.czunyi.dto.SectionDto;
import hu.webuni.log.czunyi.mapper.MileStoneMapper;
import hu.webuni.log.czunyi.mapper.SectionMapper;
import hu.webuni.log.czunyi.model.Section;
import hu.webuni.log.czunyi.service.SectionService;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

	@Autowired
	SectionService sectionService;
	
	@Autowired
	SectionMapper sectionMapper;
	
	@Autowired
	MileStoneMapper mileStoneMapper;
	
	@GetMapping
	public List<SectionDto> getAll() {
		return sectionMapper.sectionsToDtos(sectionService.findAll());
	}
	
	@PostMapping
	public SectionDto createSection(@RequestBody SectionDto sectionDto) {
		Section section = sectionService
				.save(sectionMapper.dtoToSection(sectionDto));
		return sectionMapper.sectionToDto(section);
	}
	
//	@PostMapping("/{sectionId}/mileStone")
//	public SectionDto addNewMileStone(@PathVariable long sectionId, @RequestBody MileStoneDto mileStoneDto) {
//		try {
//			return sectionMapper
//					.sectionToDto(sectionService.addMileStone(sectionId, mileStoneMapper.dtoToMileStone(mileStoneDto)));
//		} catch (NoSuchElementException e) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//	}
}
