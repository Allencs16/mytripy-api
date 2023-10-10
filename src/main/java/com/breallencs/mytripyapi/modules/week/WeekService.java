package com.breallencs.mytripyapi.modules.week;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WeekService {
  
  ResponseEntity<?> createNewWeek(WeekDTO weekDTO);

  ResponseEntity<?> disableWeek(Long weekId);

  List<WeekDTO> getWeek();
}
