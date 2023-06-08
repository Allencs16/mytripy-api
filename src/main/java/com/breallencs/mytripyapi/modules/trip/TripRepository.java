package com.breallencs.mytripyapi.modules.trip;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;


public interface TripRepository extends JpaRepository<Trip, Long>{

  List<Trip> findByUserId(Long id);

  Trip findByUserIdAndStartDay(Object userId, LocalDate startDay);
  
}
