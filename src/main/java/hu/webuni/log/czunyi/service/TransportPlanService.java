package hu.webuni.log.czunyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.log.czunyi.model.Section;
import hu.webuni.log.czunyi.model.TransportPlan;
import hu.webuni.log.czunyi.repository.SectionRepository;
import hu.webuni.log.czunyi.repository.TransportPlanRepository;

@Service
public class TransportPlanService {

	@Autowired
	TransportPlanRepository transportPlanRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	SectionService sectionService;
	
	public List<TransportPlan> findAll() {
		return transportPlanRepository.findAll();
	}
	
	@Transactional
	public TransportPlan save(TransportPlan transportPlan) {
		return transportPlanRepository.save(transportPlan);
	}

	@Transactional
	public TransportPlan addSection(long transportPlanId, Section section) {
		TransportPlan transportPlan = transportPlanRepository.findById(transportPlanId).get();
		transportPlan.addSection(section);
		sectionRepository.save(section);
		return transportPlan;
	}
}
