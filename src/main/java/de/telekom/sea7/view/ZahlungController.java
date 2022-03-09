package de.telekom.sea7.view;

import java.util.Optional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.Zahlungen;
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
		Iterable<IbanImpl> iterableIban = ibanrepository.findAll();
		int ibanexist = 0;
		int ibanid = 0;
		for (IbanImpl iban1 : iterableIban) {
			if (iban.getIban().startsWith(iban1.getIban())) {
				ibanexist++;
				if (ibanexist == 1) {
					ibanid = iban1.getIban_id();
				}
			}
		}
		if (ibanexist == 0) {
			iban = ibanrepository.save(iban);
		} else {
			iban.setIban_id(ibanid);
			iban = ibanrepository.save(iban);
		}
		zahlung = repository.save(zahlung);
		return zahlung;
	}

	@PutMapping("/zahlung/")
	public ZahlungImpl putZahlung(@RequestBody ZahlungImpl zahlung) {
		IbanImpl iban = new IbanImpl();
		iban = zahlung.getIban();
		int ibanexist = 0;
		int ibanid = 0;
		int ibanid_old = 0;
		ibanid_old = repository.findById(zahlung.getZahlung_id()).get().getIban().getIban_id();
		System.out.println("ibanid_old " + ibanid_old);
		Iterable<IbanImpl> iterableIban = ibanrepository.findAll();
		for (IbanImpl iban1 : iterableIban) {
			if (iban.getIban().startsWith(iban1.getIban())) {
				ibanexist++;
				if (ibanexist == 1) {
					ibanid = iban1.getIban_id();
				}
			}
		}
		if (ibanexist == 0) {
			iban = ibanrepository.save(iban);
			zahlung = repository.save(zahlung);
		} else {
			iban.setIban_id(ibanid);
			iban = ibanrepository.save(iban);
			zahlung = repository.save(zahlung);
			if (ibanid_old != ibanid) ibanrepository.deleteById(ibanid_old);
		}
		return zahlung;
	}

	@DeleteMapping("/zahlung/{zahlung_id}/")
	public int deleteZahlung(@PathVariable int zahlung_id) {
		int ibanid = 0;
		Optional<ZahlungImpl> optionalZahlung = repository.findById(zahlung_id);
		ibanid = optionalZahlung.get().getIban().getIban_id();
		repository.deleteById(zahlung_id);
		if (ibanid != 0) {
			ibanrepository.deleteById(ibanid);	
		}	
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