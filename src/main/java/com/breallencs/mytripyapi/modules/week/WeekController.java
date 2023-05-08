package com.breallencs.mytripyapi.modules.week;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/week"})
public class WeekController {

  private WeekRepository weekRepository;

  public WeekController(WeekRepository weekRepository){
    this.weekRepository = weekRepository;
  }

  @GetMapping
  public List<Week> getWeeks(){
    return weekRepository.findAll();
  }

  @GetMapping(path = "/{userId}")
  public List<Week> getByUser(@PathVariable String userId){
    return weekRepository.findByUserId(userId);
  }
  
}
