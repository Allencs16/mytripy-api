package com.breallencs.mytripyapi.modules.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TripDto {
  
  private String name;

  private String place;

  private Long idUser;

  private String coordinates;

  private String description;

  private Boolean isQuiet;

  private Float price;
  
}
