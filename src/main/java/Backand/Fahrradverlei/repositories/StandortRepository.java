package Backand.Fahrradverlei.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Backand.Fahrradverlei.entities.Standort;

public interface StandortRepository extends JpaRepository<Standort, UUID> {

}
