package com.WildCircus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WildCircus.entities.Circus;

public interface CircusRepository extends JpaRepository<Circus, Integer>{
	List<Circus> findByTown(String town);
}
