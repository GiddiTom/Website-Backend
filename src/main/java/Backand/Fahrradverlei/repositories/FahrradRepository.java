package Backand.Fahrradverlei.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Backand.Fahrradverlei.entities.Fahrrad;

public interface FahrradRepository extends JpaRepository<Fahrrad, UUID>{
	
	
	


}