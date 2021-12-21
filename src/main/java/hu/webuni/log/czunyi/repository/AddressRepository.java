package hu.webuni.log.czunyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.log.czunyi.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
