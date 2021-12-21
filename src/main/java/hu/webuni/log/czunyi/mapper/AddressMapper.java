package hu.webuni.log.czunyi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.webuni.log.czunyi.dto.AddressDto;
import hu.webuni.log.czunyi.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	AddressDto addressToDto(Address address);

	Address dtoToAddress(AddressDto addressDto);

	List<AddressDto> addressToDtos(List<Address> address);

	List<Address> dtosToAddress(List<AddressDto> addressDtos);
}
