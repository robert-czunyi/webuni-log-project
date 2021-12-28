package hu.webuni.log.czunyi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.log.czunyi.dto.SectionDto;
import hu.webuni.log.czunyi.dto.TransportPlanDto;
import hu.webuni.log.czunyi.mapper.SectionMapper;
import hu.webuni.log.czunyi.mapper.TransportPlanMapper;
import hu.webuni.log.czunyi.model.TransportPlan;
import hu.webuni.log.czunyi.service.TransportPlanService;

@RestController
@RequestMapping("/api/transportPlans")
public class TransportPlanController {

	@Autowired
	TransportPlanMapper transportPlanMapper;

	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	SectionMapper sectionMapper;
	
	@GetMapping
	public List<TransportPlanDto> getAll() {
		return transportPlanMapper.transportPlansToDtos(transportPlanService.findAll());
	}

	@PostMapping
	public TransportPlanDto createTransportPlan(@RequestBody @Valid TransportPlanDto transportPlanDto) {
		TransportPlan transportPlan = transportPlanService
				.save(transportPlanMapper.dtoToTransportPlan(transportPlanDto));
		return transportPlanMapper.transportPlanToDto(transportPlan);
	}
	
	@PostMapping("/{transportPlanId}/section")
	public TransportPlanDto addNewSection(@PathVariable long transportPlanId, @RequestBody SectionDto sectionDto) {
		try {
			return transportPlanMapper
					.transportPlanToDto(transportPlanService.addSection(transportPlanId, sectionMapper.dtoToSection(sectionDto)));
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
