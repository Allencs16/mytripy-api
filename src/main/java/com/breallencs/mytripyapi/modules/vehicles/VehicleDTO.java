package com.breallencs.mytripyapi.modules.vehicles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {

  private Long id;
  
  private String name;

  private Double price;

  private String brand;

  private Double kmAveragePerLiter;

  private Double maxDistance;
}
