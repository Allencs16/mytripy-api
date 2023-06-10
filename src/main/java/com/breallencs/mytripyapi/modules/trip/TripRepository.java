package com.breallencs.mytripyapi.modules.trip;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;


public interface TripRepository extends JpaRepository<Trip, Long>, TripRepositoryCustom{

  List<Trip> findByUserId(Long id);

  Trip findByUser_IdAndStartDay(Long userId, LocalDate startDay);
  
}
