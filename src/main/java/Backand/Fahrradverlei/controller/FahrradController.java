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

import Backand.Fahrradverlei.dao.FahrradConfigurationsObject;
import Backand.Fahrradverlei.entities.Fahrrad;
import Backand.Fahrradverlei.entities.Standort;
import Backand.Fahrradverlei.repositories.FahrradRepository;
import Backand.Fahrradverlei.repositories.StandortRepository;



@RestController
@RequestMapping("/fahrrad")
public class FahrradController {
	
	@Autowired
	private FahrradRepository fahrradrepository;
	
	@Autowired
	private StandortRepository standortrepository;
		
	@GetMapping("")	
	public ResponseEntity<Iterable<Fahrrad>> getFahrrader(){
		return new ResponseEntity<>(fahrradrepository.findAll(),HttpStatus.OK);	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getFahrrad(@PathVariable UUID id) {
		Optional<Fahrrad> fahrrad = fahrradrepository.findById(id);
		try {
			Fahrrad toReturn = fahrrad.get();
			return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Fahrrad nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody FahrradConfigurationsObject uco){
		
		Optional<Fahrrad> toUpdate = fahrradrepository.findById(id);
		Fahrrad u = new Fahrrad();
		Standort standort =  standortrepository.findById(uco.standortid).get();
		try {
			UUID currentFahrrad = toUpdate.get().getId();
			u.setId(currentFahrrad);
			u.setModel(uco.model);
			u.setStandort(standort);
			u.setPictureLink(uco.pictureLink);
			
			
			fahrradrepository.save(u);
			return new ResponseEntity<Object>(u, HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Fahrrad nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> register(@RequestBody FahrradConfigurationsObject uro){
		
		Fahrrad toAdd = new Fahrrad();
		
		Standort standort;
		if(uro.standortid == null) standort = null;
		else standort =  standortrepository.findById(uro.standortid).get();
		 
		toAdd.setModel(uro.model);
		toAdd.setStandort(standort);
		toAdd.setPictureLink(uro.pictureLink);
		
		return new ResponseEntity<Object>(fahrradrepository.save(toAdd), HttpStatus.CREATED);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable UUID id){
		
		try {
			Optional<Fahrrad> o = fahrradrepository.findById(id);
			fahrradrepository.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (NoSuchElementException nSE) {
			return new ResponseEntity<Object>("Fahrrad nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}

}


