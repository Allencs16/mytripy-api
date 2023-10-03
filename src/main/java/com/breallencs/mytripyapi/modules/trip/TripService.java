package com.breallencs.mytripyapi.modules.trip;

import org.springframework.stereotype.Service;

@Service
public interface TripService {
  
  Trip createTrip(TripDto tripDto);

  TripQuantitativesDTO totalKmByMonth();
}
