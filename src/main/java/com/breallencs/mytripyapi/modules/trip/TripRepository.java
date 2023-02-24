package com.breallencs.mytripyapi.modules.trip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, String>{
  
}
