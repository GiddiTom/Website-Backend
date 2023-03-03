package Backand.Fahrradverlei.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Backand.Fahrradverlei.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking, UUID>{
	
	
	
}