package de.telekom.sea7.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.model.IbanImpl;

@Repository
public interface IbanRepository extends CrudRepository<IbanImpl, Integer> {
	
}