package Backand.Fahrradverlei.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Backand.Fahrradverlei.entities.Fahrrad;
import Backand.Fahrradverlei.entities.Standort;

public interface FahrradRepository extends JpaRepository<Fahrrad, UUID>{
	
	
	Optional<List<Fahrrad>> findAllByStandort(Standort standort);


}