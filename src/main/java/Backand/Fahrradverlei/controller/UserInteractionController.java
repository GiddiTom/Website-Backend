package Backand.Fahrradverlei.controller;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backand.Fahrradverlei.entities.User;
import Backand.Fahrradverlei.repositories.BookingRepository;
import Backand.Fahrradverlei.repositories.UserRepository;

@Controller
@RestController
@RequestMapping("/users")
public class UserInteractionController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}/bookings")
	public ResponseEntity<Object> getBookings(@PathVariable UUID id){
		Optional<User> u = userRepository.findById(id);
		try {
			User user =u.get();
			return new ResponseEntity<Object>(bookingRepository.findAllByUser(user).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Gibt keine Buchungen bro", HttpStatus.NOT_FOUND);
		}
	}

}
