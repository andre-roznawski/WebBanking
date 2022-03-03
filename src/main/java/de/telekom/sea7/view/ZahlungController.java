package de.telekom.sea7.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.model.IbanImpl;
import de.telekom.sea7.model.ZahlungImpl;
import de.telekom.sea7.persistence.ZahlungRepository;
import de.telekom.sea7.persistence.IbanRepository;

@RestController
public class ZahlungController {

	@Autowired
	private ZahlungRepository repository;
	@Autowired
	private IbanRepository ibanrepository;
	
	@GetMapping("/zahlung/{zahlung_id}/")
	public ZahlungImpl getZahlung(@PathVariable("zahlung_id") int zahlung_id) {
		Optional<ZahlungImpl> optionalZahlung = repository.findById(zahlung_id);
		if (optionalZahlung.isPresent()) {
			return optionalZahlung.get();
		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Die angefragte ID gibt es nicht!");
			ZahlungImpl zahlung0 = new ZahlungImpl();
			IbanImpl iban0 = new IbanImpl();
			zahlung0.setZahlung(0, "", 0f, "", false, iban0);
			return zahlung0;
		}
	}

	@GetMapping("/zahlung/")
	public Iterable<ZahlungImpl> getAll() {
		Iterable<ZahlungImpl> iterableZahlung = repository.findAll();
		return iterableZahlung;
	}

	@PostMapping("/zahlung/")
	public ZahlungImpl postZahlung(@RequestBody ZahlungImpl zahlung) {
		IbanImpl iban = new IbanImpl();
		iban = zahlung.getIban();
		ibanrepository.save(iban);
		repository.save(zahlung);
		return zahlung;
	}

	@PutMapping("/zahlung/")
	public ZahlungImpl putZahlung(@RequestBody ZahlungImpl zahlung) {
		IbanImpl iban = new IbanImpl();
		iban = zahlung.getIban();
		ibanrepository.save(iban);
		repository.save(zahlung);
		return zahlung;
	}

	@DeleteMapping("/zahlung/{zahlung_id}/")
	public int deleteZahlung(@PathVariable int zahlung_id) {
		repository.deleteById(zahlung_id);
		return zahlung_id;

	}

}
//public interface CrudRepository<T, ID> extends Repository<T, ID> {
//    // Create and Update an entity
//    <S extends T> S save(S var1);
//    // Select one
//    Optional<T> findById(ID var1);
//    // Select all
//    Iterable<T> findAll();
//    // Delete
//    void deleteById(ID var1);
//    // other methods omitted for brevity
//
//}
