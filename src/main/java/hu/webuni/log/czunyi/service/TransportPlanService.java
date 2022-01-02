package hu.webuni.log.czunyi.service;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.log.czunyi.config.LogConfigProperties;
import hu.webuni.log.czunyi.dto.TransportPlanDelayDto;
import hu.webuni.log.czunyi.dto.TransportPlanDto;
import hu.webuni.log.czunyi.mapper.TransportPlanMapper;
import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.model.TransportPlan;
import hu.webuni.log.czunyi.repository.MileStoneRepository;
import hu.webuni.log.czunyi.repository.TransportPlanRepository;

@Service
public class TransportPlanService {

	@Autowired
	TransportPlanRepository transportPlanRepository;
	
	@Autowired
	MileStoneRepository mileStoneRepository;
	
	@Autowired
	TransportPlanMapper transportPlanMapper;
	
	@Autowired
	LogConfigProperties logConfigProperties;
	
	public List<TransportPlan> findAll() {
		return transportPlanRepository.findAll();
	}
	
	@Transactional
	public TransportPlan save(TransportPlan transportPlan) {
		return transportPlanRepository.save(transportPlan);
	}
	
	@Transactional
	public TransportPlanDto delay (Long id, TransportPlanDelayDto transportPlanDelayDto) {
		TransportPlan transportPlan = transportPlanRepository.findById(id).get();
		MileStone mileStone = mileStoneRepository.findById(transportPlanDelayDto.getmileStoneId()).get();
		mileStone.setPlannedTime(mileStone.getPlannedTime().plusMinutes(transportPlanDelayDto.getDelayMin()));
		return transportPlanMapper.transportPlanToDto(transportPlan);
	}
	
	public double modifyRevenueWithDelay(TransportPlanDelayDto transportPlanDelayDto) {
		TreeMap<Integer, Double> limits = logConfigProperties.getDelay().getLimits();
		Entry<Integer, Double> floorEntry = limits.floorEntry(transportPlanDelayDto.getDelayMin());
		return floorEntry == null ? 0 : floorEntry.getValue();
	}
	
	@Transactional
	public TransportPlanDto modifyRevenueValue(TransportPlan transportPlan, TransportPlanDelayDto transportPlanDelayDto) {
		transportPlan.setRevenue((100 - modifyRevenueWithDelay(transportPlanDelayDto)) / 100
				* transportPlan.getRevenue());
		return transportPlanMapper.transportPlanToDto(transportPlan);
	}
}
