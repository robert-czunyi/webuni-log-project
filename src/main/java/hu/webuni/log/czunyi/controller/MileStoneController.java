package hu.webuni.log.czunyi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.log.czunyi.dto.MileStoneDto;
import hu.webuni.log.czunyi.mapper.MileStoneMapper;
import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.service.MileStoneService;

@RestController
@RequestMapping("/api/mileStones")
public class MileStoneController {

	@Autowired
	MileStoneMapper mileStoneMapper;
	
	@Autowired
	MileStoneService mileStoneService;
	
	@GetMapping
	public List<MileStoneDto> getAll() {
		return mileStoneMapper.mileStonesToDtos(mileStoneService.findAll());
	}

	@PostMapping
	public MileStoneDto createMileStone(@RequestBody @Valid MileStoneDto mileStoneDto) {
		MileStone mileStone = mileStoneService
				.save(mileStoneMapper.dtoToMileStone(mileStoneDto));
		return mileStoneMapper.mileStoneToDto(mileStone);
	}
}
