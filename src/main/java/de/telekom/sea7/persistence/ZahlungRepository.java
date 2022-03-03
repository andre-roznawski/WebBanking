package de.telekom.sea7.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.model.ZahlungImpl;


@Repository
public interface ZahlungRepository extends CrudRepository<ZahlungImpl, Integer> {

}