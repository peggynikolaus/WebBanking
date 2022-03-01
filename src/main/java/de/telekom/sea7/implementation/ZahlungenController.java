package de.telekom.sea7.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ZahlungenController {

	@Autowired
	ZahlungRepository zahlungRep;

	@GetMapping("/zahlungDB")
	@ResponseBody
	//zeigt die gesamte Liste
	public List<ZahlungEntity> getAll() {
		List<ZahlungEntity> zahlungsListe = zahlungRep.findAll();
		return zahlungsListe;
	}
	
	@GetMapping("/onezahlungDB/{id}")
	@ResponseBody
	//zeigt einzelnen Datensatz
	public Optional<ZahlungEntity> getOne(@PathVariable(name="id") Long id) {
		Optional<ZahlungEntity> zahlungOne = zahlungRep.findById(id);
		return zahlungOne;
	}
	
	@PostMapping("/newzahlungDB/")
	//hinzufuegen eines Datensatzes
	public void addOne(@RequestBody ZahlungEntity zahlungAdd) {
		zahlungRep.save(zahlungAdd);
	}
	
	@DeleteMapping("/deletezahlungDB/{id}")
	//loeschen eines Datensatzes
	public void deleteOne(@PathVariable("id") Long id) {
		zahlungRep.deleteById(id);
	}
	
}
