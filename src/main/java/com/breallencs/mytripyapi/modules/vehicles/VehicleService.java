package com.breallencs.mytripyapi.modules.vehicles;

import org.springframework.stereotype.Service;

@Service
public interface VehicleService {
  
  Vehicles createNewVehicle(VehicleDTO vehicleDTO);

  Vehicles editVehicle(Long id, VehicleDTO vehicleDTO);
}
