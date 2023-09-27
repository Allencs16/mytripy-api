package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.modules.user.UserRepository;

@Service
public class WeekServiceImpl implements WeekService{

  private WeekRepository weekRepository;
  private UserRepository userRepository;

  public WeekServiceImpl(WeekRepository weekRepository, UserRepository userRepository){
    this.weekRepository = weekRepository;
    this.userRepository = userRepository;
  }

  @Override
  public ResponseEntity<?> createNewWeek(WeekDTO weekDTO) {
    Week newWeek = new Week();
    
    newWeek.setUser(userRepository.findById(weekDTO.getUserId()));
    newWeek.setStartDate(weekDTO.getStartDate());
    newWeek.setEndDate(weekDTO.getEndDate());
    newWeek.setCurrent(true);
    weekRepository.save(newWeek);

    return ResponseEntity.ok(newWeek);
  }

  @Override
  public ResponseEntity<?> disableWeek(Long weekId) {
    Week week = weekRepository.findById(weekId).get();

    week.setCurrent(false);

    weekRepository.save(week);
    
    return ResponseEntity.ok(week);
  }

  @Override
  public List<Week> getWeek() {
    List<Week> weeksFromDb = weekRepository.findAll();

    LocalDate nowDate = LocalDate.now();

    for (Week week : weeksFromDb) {
      if(week.getEndDate().isBefore(nowDate)){
        week.setCurrent(false);
        weekRepository.saveAndFlush(week);
      } else if(week.getStartDate().isBefore(nowDate)){
        week.setCurrent(true);
        weekRepository.saveAndFlush(week);
      }
    }

    return weeksFromDb;
  }
  
}
