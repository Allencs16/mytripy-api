package com.breallencs.mytripyapi.modules.stays;

import org.springframework.stereotype.Service;

@Service
public class StaysServiceImpl implements StaysService{

  private StaysRepository staysRepository;

  StaysServiceImpl(StaysRepository staysRepository){
    this.staysRepository = staysRepository;
  }

  @Override
  public Stays createStays(StaysDTO staysDTO) {
    Stays stay = new Stays();

    stay.setName(staysDTO.getName());
    stay.setDays(staysDTO.getDays());
    stay.setPrice(staysDTO.getPrice());
    stay.setTotalPrice(staysDTO.getPrice() * staysDTO.getDays());
    
    this.staysRepository.saveAndFlush(stay);

    return stay;
  }
  
}
