package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TripDto {

  private String description;

  private String name;
  private String state;
  private Double distanceFromSource;
  private Double price;
  private String place;
  private Double food;
  private LocalDate startDay;
  private LocalDate endDay;
  private Long userId;
  private Long stayId;
  private Long vehicleId;
  private Long weekId;
  
}
