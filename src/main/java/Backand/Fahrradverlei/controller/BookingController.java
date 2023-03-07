package Backand.Fahrradverlei.controller;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backand.Fahrradverlei.dao.BookingConfigurationsObject;
import Backand.Fahrradverlei.entities.Booking;
import Backand.Fahrradverlei.entities.Fahrrad;
import Backand.Fahrradverlei.entities.User;
import Backand.Fahrradverlei.repositories.BookingRepository;
import Backand.Fahrradverlei.repositories.FahrradRepository;
import Backand.Fahrradverlei.repositories.UserRepository;

@Controller
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepositroy;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FahrradRepository fahrradrepository;
	
	
	@PostMapping("")
	public ResponseEntity<Object> addBooking(@RequestBody BookingConfigurationsObject uro){
		
		User user = userRepository.findById(uro.userID).get();
		Fahrrad vo = fahrradrepository.findById(uro.fahrradID).get();
		
			try {
				
				Booking toAdd = new Booking();
				
				toAdd.setApprxReturnDate(uro.apprxReturnDate);
				toAdd.setBookingDate(uro.bookingDate);
				toAdd.setUser(user);
				toAdd.setVo(vo);
				
				return new ResponseEntity<Object>(bookingRepositroy.save(toAdd), HttpStatus.CREATED);
				
			} catch(Exception e) {
				
				return new ResponseEntity<Object>(e.getStackTrace(),HttpStatus.CONFLICT);
			}
		
	}

	@GetMapping("")
	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(bookingRepositroy.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSpecific(@PathVariable UUID id){
		try {
			return new ResponseEntity<Object>(bookingRepositroy.findById(id).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id){
		
		try {
			Optional<Booking> o = bookingRepositroy.findById(id);
			bookingRepositroy.deleteById(o.get().getId());
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (NoSuchElementException nSE) {
			return new ResponseEntity<Object>("Buchung gibts nicht", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/return/{id}")
		public ResponseEntity<Object> addBooking(@PathVariable UUID id){
			
			try {
				Optional<Booking> o = bookingRepositroy.findById(id);
				Booking b = o.get();
				bookingRepositroy.save(b);
				return new ResponseEntity<>(id, HttpStatus.OK);
			} catch (NoSuchElementException nSE) {
				return new ResponseEntity<Object>("Buchung gibts nicht", HttpStatus.NOT_FOUND);
			}
			
		}

	}

