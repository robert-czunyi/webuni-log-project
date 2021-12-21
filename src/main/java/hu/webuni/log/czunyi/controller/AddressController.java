package hu.webuni.log.czunyi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.log.czunyi.dto.AddressDto;
import hu.webuni.log.czunyi.mapper.AddressMapper;
import hu.webuni.log.czunyi.model.Address;
import hu.webuni.log.czunyi.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	AddressMapper addressMapper;

	@Autowired
	AddressService addressService;

	@GetMapping
	public List<AddressDto> getAll() {
		return addressMapper.addressToDtos(addressService.findAll());
	}

	@GetMapping("/{id}")
	public AddressDto getById(@PathVariable long id) {
		Address address = addressService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return addressMapper.addressToDto(address);
	}

	@PostMapping
	public AddressDto createAddress(@RequestBody @Valid AddressDto addressDto) {
		if (addressDto.getId() == null && addressDto.getCountry() != 0 && addressDto.getCity() != null
				&& !(addressDto.getCity().isEmpty()) && addressDto.getZipCode() != 0 && addressDto.getStreet() != null
				&& !(addressDto.getStreet().isEmpty()) && addressDto.getNumber() != 0) {
			Address address = addressService.save(addressMapper.dtoToAddress(addressDto));
			return addressMapper.addressToDto(address);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable long id) {
		for (Address address : addressService.findAll()) {
			if (address.getId() == id) {
				addressService.delete(id);
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public AddressDto modifyAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
		if (addressDto.getId() != id || addressDto.getCountry() == 0 || addressDto.getCity() == null
				|| addressDto.getCity().isEmpty() || addressDto.getZipCode() == 0 || addressDto.getStreet() == null
				|| addressDto.getStreet().isEmpty() || addressDto.getNumber() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		addressDto.setId(id);
		Address updateAddress = addressService.update(addressMapper.dtoToAddress(addressDto));
		if (updateAddress == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return addressMapper.addressToDto(updateAddress);
	}
}
