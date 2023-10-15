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

    if (weekRepository.findByStartDateAndUserId(weekDTO.getStartDate(), weekDTO.getUserId()).isPresent()) {
      return ResponseEntity.badRequest().body("Já existe uma semana nessa data inicio para esse Usuário");
    }

    newWeek.setTotalKm(0.0);
    newWeek.setTotalBudget(0.0);
    newWeek.setTotalExpenses(0.0);
    newWeek.setUser(userRepository.findById(weekDTO.getUserId()));
    newWeek.setStartDate(weekDTO.getStartDate());
    newWeek.setEndDate(weekDTO.getEndDate());
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
  public List<WeekDTO> getWeek() {
    return weekRepository.getAllWeeks();
  }

  @Override
  public WeekQuantitativesDTO getQuantitatives() {
    LocalDate today = LocalDate.now();
    LocalDate firstDay = today.withDayOfMonth(1);
    LocalDate lastDay = today.withDayOfMonth(firstDay.getMonth().length(today.isLeapYear()));
    WeekQuantitativesDTO weekQuantitativesDTO = new WeekQuantitativesDTO();
    List<Week> weekLists = weekRepository.findAll();

    for(Week week : weekLists){
      if(week.getStartDate().isAfter(firstDay) || week.getEndDate().isBefore(lastDay)){
        weekQuantitativesDTO.setTotalKm(weekQuantitativesDTO.getTotalKm() + week.getTotalKm());
        weekQuantitativesDTO.setTotalPrice(weekQuantitativesDTO.getTotalPrice() + week.getTotalExpenses());
      }
    }
    
    return weekQuantitativesDTO;
  }
  
}
