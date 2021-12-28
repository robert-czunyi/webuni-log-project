package hu.webuni.log.czunyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.log.czunyi.model.MileStone;
import hu.webuni.log.czunyi.repository.MileStoneRepository;

@Service
public class MileStoneService {

	@Autowired
	MileStoneRepository mileStoneRepository;
	
	public List<MileStone> findAll() {
		return mileStoneRepository.findAll();
	}
	
	@Transactional
	public MileStone save(MileStone mileStone) {
		return mileStoneRepository.save(mileStone);
	}
}
