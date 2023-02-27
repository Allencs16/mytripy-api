package com.breallencs.mytripyapi.modules.trip;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long>{

  List<Trip> findByUserId(Long id);
  
}
