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

import Backand.Fahrradverlei.dao.UserConfigurationObject;
import Backand.Fahrradverlei.dao.UserRegistrationObject;
import Backand.Fahrradverlei.entities.User;
import Backand.Fahrradverlei.repositories.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
		
	@GetMapping("")	
	public ResponseEntity<Iterable<User>> getUsers(){
		return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getUser(@PathVariable UUID id) {
		Optional<User> user = userRepository.findById(id);
		try {
			User toReturn = user.get();
			return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("User nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UserConfigurationObject uco){
		
		Optional<User> toUpdate = userRepository.findById(id);
		User u = new User();
		
		try {
			UUID currentUser = toUpdate.get().getId();
			u.setId(currentUser);
			u.setPassword(uco.password);
			u.setEmail(uco.email);
			u.setFirstName(uco.firstName);
			u.setName(uco.name);
			u.setNumber(uco.number);
			u.setStreet(uco.street);
			u.setCity(uco.city);
			
			userRepository.save(u);
			return new ResponseEntity<Object>(u, HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("User nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> register(@RequestBody UserRegistrationObject uro){
		
		boolean alreadyExists = false;
		
		if(!(uro.passwordHash.equals(uro.passwordConfirmHash))) {
			return new ResponseEntity<Object>("Incorrect password!", HttpStatus.UNAUTHORIZED);
		}
		
		
	
		
		
		try {
			@SuppressWarnings("unused")
			User user = userRepository.findByEmail(uro.email).get();
			alreadyExists = true;
		}catch(Exception e) {};
		
		if(alreadyExists) {
			return new ResponseEntity<Object>("User gibts schon", HttpStatus.NOT_ACCEPTABLE);
		}
		
		User toAdd = new User();
		
		
		toAdd.setEmail(uro.email);
		toAdd.setName(uro.name);
		toAdd.setFirstName(uro.firstName);
		toAdd.setPassword(uro.passwordHash);
		toAdd.setStreet(uro.street);
		toAdd.setNumber(uro.number);
		toAdd.setCity(uro.city);
	
		return new ResponseEntity<Object>(userRepository.save(toAdd), HttpStatus.CREATED);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable UUID id){
		
		try {
			Optional<User> o = userRepository.findById(id);
			userRepository.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (NoSuchElementException nSE) {
			return new ResponseEntity<Object>("User nicht gefunden", HttpStatus.NOT_FOUND);
		}
	}

}


