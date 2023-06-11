package com.breallencs.mytripyapi.modules.stays;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/stays"})
public class StaysController {

  private StaysRepository staysRepository;
  private StaysService staysService;
  
  StaysController(StaysRepository staysRepository, StaysService staysService){
    this.staysRepository = staysRepository;
    this.staysService = staysService;
  }

  @GetMapping
  public List<Stays> getAllStays(){
    return this.staysRepository.findAll();
  }

  @PostMapping
  public Stays createStays(@RequestBody StaysDTO staysDTO){
    return this.staysService.createStays(staysDTO);
  }
}
