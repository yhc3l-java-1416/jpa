package se.coredev.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import se.coredev.jpa.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
