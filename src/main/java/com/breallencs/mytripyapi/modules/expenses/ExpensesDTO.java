package com.breallencs.mytripyapi.modules.expenses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesDTO {
  
  private Integer type;

  private Double value;

  private LocalDateTime expenseDate;

  private Long weekId;
}
