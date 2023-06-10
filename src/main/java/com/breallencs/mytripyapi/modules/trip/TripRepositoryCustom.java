package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;

public interface TripRepositoryCustom {

  Trip getByUserAndStartDay(Long userId, LocalDate startDay);
  
}
