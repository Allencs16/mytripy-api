package com.breallencs.mytripyapi.modules.stays;

import org.springframework.stereotype.Service;

@Service
public interface StaysService {
  
  Stays createStays(StaysDTO staysDTO);
}
