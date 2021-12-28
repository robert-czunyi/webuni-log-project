package hu.webuni.log.czunyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.model.Section;
import hu.webuni.log.czunyi.repository.MileStoneRepository;
import hu.webuni.log.czunyi.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	MileStoneRepository mileStoneRepository;
	
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}
	
	@Transactional
	public Section save(Section section) {
		return sectionRepository.save(section);
	}
	
//	@Transactional
//	public Section addMileStone(long sectionId, MileStone mileStone) {
//		Section section = sectionRepository.findById(sectionId).get();
//		section.addMileStone(mileStone);
//		mileStoneRepository.save(mileStone);
//		return section;
//	}
}
