package com.breallencs.mytripyapi.modules.week;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/week"})
public class WeekController {

  private WeekRepository weekRepository;
  private WeekService weekService;

  public WeekController(WeekRepository weekRepository, WeekService weekService){
    this.weekRepository = weekRepository;
    this.weekService = weekService;
  }

  @GetMapping
  public List<Week> getWeeks(){
    return weekRepository.findAll();
  }

  @GetMapping(path = "/{userId}")
  public List<Week> getByUser(@PathVariable String userId){
    return weekRepository.findByUserId(userId);
  }

  @PostMapping
  public ResponseEntity<?> createNewWeek(@RequestBody WeekDTO weekDTO){
    return weekService.createNewWeek(weekDTO);
  }

  @PutMapping(path = "/{weekId}")
  public ResponseEntity<?> disableWeek(@PathVariable Long weekId){
    return weekService.disableWeek(weekId);
  }
  
}
