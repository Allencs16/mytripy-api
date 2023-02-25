package com.breallencs.mytripyapi.modules.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TripDto {
  
  private String name;
  private String place;
  private Long idUsuario;
}