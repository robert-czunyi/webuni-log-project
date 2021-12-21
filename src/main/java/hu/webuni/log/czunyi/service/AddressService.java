package hu.webuni.log.czunyi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.log.czunyi.model.Address;
import hu.webuni.log.czunyi.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	public Optional<Address> findById(long id) {
		return addressRepository.findById(id);
	}

	@Transactional
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	@Transactional
	public void delete(long id) {
		addressRepository.deleteById(id);
	}
	
	@Transactional
	public Address update(Address address) {
		if(address.getId() == null || !addressRepository.existsById(address.getId()))
			return null;
		return addressRepository.save(address);
	}
}
