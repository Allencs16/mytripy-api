package com.breallencs.mytripyapi.modules.trip;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TripService {
  
  ResponseEntity<?> createTrip(TripDto tripDto);

  TripQuantitativesDTO totalKmByMonth();
}
