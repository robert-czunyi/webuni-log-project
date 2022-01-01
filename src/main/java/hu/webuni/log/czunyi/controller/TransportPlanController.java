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

import hu.webuni.log.czunyi.dto.SectionDto;
import hu.webuni.log.czunyi.dto.TransportPlanDelayDto;
import hu.webuni.log.czunyi.dto.TransportPlanDto;
import hu.webuni.log.czunyi.mapper.MileStoneMapper;
import hu.webuni.log.czunyi.mapper.SectionMapper;
import hu.webuni.log.czunyi.mapper.TransportPlanMapper;
import hu.webuni.log.czunyi.model.TransportPlan;
import hu.webuni.log.czunyi.repository.MileStoneRepository;
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
		TransportPlanDto transportPlan = transportPlanMapper
				.transportPlanToDto(transportPlanRepository.findById(id).get());

		List<SectionDto> sectionDtos = transportPlan.getSection();

		TransportPlanDto transportPlanDto = null;
		TransportPlanDelayDto transportPlanDelayDtoNext = null;
		transportPlanDelayDtoNext.setmileStoneId(transportPlanDelayDto.getmileStoneId() + 1);
		for (SectionDto sectionDto : sectionDtos) {
			if (sectionDto.getFromMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId()
					|| sectionDto.getToMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId()) {
				transportPlanDto = transportPlanService.delay(id, transportPlanDelayDto);
				TransportPlanDto transportPlanDtoWithNewRevenue = null;
				transportPlanDtoWithNewRevenue
						.setRevenue((100 - transportPlanService.modifyRevenueWithDelay(transportPlanDelayDto))
								* transportPlanDto.getRevenue());
			}

			if (sectionDto.getFromMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId() + 1
					|| sectionDto.getToMileStone().getMileStoneId() == transportPlanDelayDto.getmileStoneId() + 1) {
				transportPlanDto = transportPlanService.delay(id, transportPlanDelayDtoNext);
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return transportPlanDto;
	}
}
