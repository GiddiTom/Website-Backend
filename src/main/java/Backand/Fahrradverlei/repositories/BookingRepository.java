package Backand.Fahrradverlei.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Backand.Fahrradverlei.entities.Booking;
import Backand.Fahrradverlei.entities.User;


public interface BookingRepository extends JpaRepository<Booking, UUID>{


	Optional<List<Booking>> findAllByUser(User user);
	
	
	
}