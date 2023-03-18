package Backand.Fahrradverlei.controller;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

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

import Backand.Fahrradverlei.dao.StandortConfigurationsObject;
import Backand.Fahrradverlei.entities.Standort;
import Backand.Fahrradverlei.repositories.FahrradRepository;
import Backand.Fahrradverlei.repositories.StandortRepository;

@RestController
@RequestMapping("/standort")
public class StandortController {
	
	@Autowired
	private StandortRepository standortrepository;
	
	@Autowired
	private FahrradRepository fahrradrepository;
		
	@GetMapping("")	
	public ResponseEntity<Iterable<Standort>> getStandorte(){
		return new ResponseEntity<>(standortrepository.findAll(),HttpStatus.OK);	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getStandort(@PathVariable UUID id) {
		Optional<Standort> standort = standortrepository.findById(id);
		try {
			Standort toReturn = standort.get();
			return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Standort nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody StandortConfigurationsObject uco){
		
		Optional<Standort> toUpdate = standortrepository.findById(id);
		Standort u = new Standort();
		
		try {
			UUID currentStandort = toUpdate.get().getId();
			u.setId(currentStandort);
			u.setAdresse(uco.adresse);
			u.setName(uco.name);
			u.setLongitude(uco.longitude);
			u.setLatitude(uco.latitude);
		
			standortrepository.save(u);
			return new ResponseEntity<Object>(u, HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Standort nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> register(@RequestBody StandortConfigurationsObject uro){
		
		Standort toAdd = new Standort();
		
		
		toAdd.setAdresse(uro.adresse);
		toAdd.setName(uro.name);
		toAdd.setLongitude(uro.longitude);
		toAdd.setLatitude(uro.latitude);
		
		return new ResponseEntity<Object>(standortrepository.save(toAdd), HttpStatus.CREATED);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable UUID id){
		
		try {
			Optional<Standort> o = standortrepository.findById(id);
			standortrepository.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (NoSuchElementException nSE) {
			return new ResponseEntity<Object>("Standort nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/fahrraeder")
	public ResponseEntity<Object> getFahrraeder(@PathVariable UUID id){
		Optional<Standort> u = standortrepository.findById(id);
		try {
			Standort standort =u.get();
			return new ResponseEntity<Object>(fahrradrepository.findAllByStandort(standort).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Gibt keine Buchungen bro", HttpStatus.NOT_FOUND);
		}
	}


}
