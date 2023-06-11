package com.breallencs.mytripyapi.modules.stays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaysDTO {
  
  private String name;

  private Double price;

  private int days;
}
