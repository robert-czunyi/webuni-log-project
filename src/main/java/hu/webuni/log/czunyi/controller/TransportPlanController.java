package hu.webuni.log.czunyi.controller;

import java.util.List;

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

import hu.webuni.log.czunyi.dto.TransportPlanDelayDto;
import hu.webuni.log.czunyi.dto.TransportPlanDto;
import hu.webuni.log.czunyi.mapper.MileStoneMapper;
import hu.webuni.log.czunyi.mapper.SectionMapper;
import hu.webuni.log.czunyi.mapper.TransportPlanMapper;
import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.model.Section;
import hu.webuni.log.czunyi.model.TransportPlan;
import hu.webuni.log.czunyi.repository.MileStoneRepository;
import hu.webuni.log.czunyi.repository.SectionRepository;
import hu.webuni.log.czunyi.repository.TransportPlanRepository;
import hu.webuni.log.czunyi.service.TransportPlanService;

@RestController
@RequestMapping("/api/transportPlans")
public class TransportPlanController {

	@Autowired
	TransportPlanMapper transportPlanMapper;

	@Autowired
	TransportPlanService transportPlanService;

	@Autowired
	TransportPlanRepository transportPlanRepository;

	@Autowired
	MileStoneRepository mileStoneRepository;

	@Autowired
	MileStoneMapper mileStoneMapper;

	@Autowired
	SectionMapper sectionMapper;

	@Autowired
	SectionRepository sectionRepository;

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

	@PostMapping("/{id}/delay")
	public TransportPlanDto modifyWithDelay(@PathVariable Long id,
			@RequestBody TransportPlanDelayDto transportPlanDelayDto) {
		TransportPlan transportPlan = transportPlanRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		MileStone mileStone = mileStoneRepository.findById(transportPlanDelayDto.getmileStoneId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		List<Section> sections = transportPlan.getSections();
		Long sectionId = null;
		for (Section section : sections) {
			if (section.getFromMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId()
					|| section.getToMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId()) {
				sectionId = section.getSectionId();
			}
		}
		if (sectionId == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		transportPlan = transportPlanMapper.dtoToTransportPlan(transportPlanService.delay(id, transportPlanDelayDto));

		Long sectionIdNext = null;
		for (Section section : sections) {
			if (section.getFromMileStone().getMileStoneId() == (transportPlanDelayDto.getmileStoneId() + 1)
					|| section.getToMileStone().getMileStoneId() == (transportPlanDelayDto.getmileStoneId()) + 1) {
				sectionIdNext = section.getSectionId();
			}
		}

		transportPlanDelayDto.setmileStoneId(transportPlanDelayDto.getmileStoneId() + 1);

		if (sectionIdNext != null) {
			transportPlan = transportPlanMapper
					.dtoToTransportPlan(transportPlanService.delay(id, transportPlanDelayDto));
		}

		transportPlan = transportPlanMapper.dtoToTransportPlan(transportPlanService.modifyRevenueValue(transportPlan, transportPlanDelayDto));

		return transportPlanMapper.transportPlanToDto(transportPlan);
	}
}
