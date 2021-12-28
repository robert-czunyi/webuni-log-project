package hu.webuni.log.czunyi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
	
	public List<Address> findAddressByExample(Address address, Pageable page){
		int country = address.getCountry();
		String city = address.getCity();
		String street = address.getStreet();
		int zipCode = address.getZipCode();
		
		Specification<Address> spec = Specification.where(null);
		
		if (country > 0) {
			spec = spec.and(AddressSpecifications.hasCountry(country));
		}
		
		if(StringUtils.hasText(city)) {
			spec = spec.and(AddressSpecifications.hasCity(city));
		}
		
		if(StringUtils.hasText(street)) {
			spec = spec.and(AddressSpecifications.hasStreet(street));
		}
		
		if (zipCode > 0) {
			spec = spec.and(AddressSpecifications.hasZipCode(zipCode));
		}
		
		Page<Address> addressPage = addressRepository.findAll(spec, page);
		List<Address> addresses = addressPage.getContent();
		
		return addresses;
	}
}
