package com.breallencs.mytripyapi.modules.budget;

import com.breallencs.mytripyapi.enums.BudgetCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDTO {
  
  private Long id;
  private Integer type;
  private Double value;
  private Long weekId;

  public BudgetDTO(Long id, Integer type, Double value) {
    this.id = id;
    this.type = type;
    this.value = value;
  }
  
}
