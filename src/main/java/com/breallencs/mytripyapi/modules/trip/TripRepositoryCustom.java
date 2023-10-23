package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;
import java.util.List;

public interface TripRepositoryCustom {

  List<Trip> getByUserAndStartDay(Long userId, LocalDate startDay);
  
}
