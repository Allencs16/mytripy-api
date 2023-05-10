package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekDTO {
    
  private LocalDate startDate;
  private LocalDate endDate;

  private Long userId;
}
