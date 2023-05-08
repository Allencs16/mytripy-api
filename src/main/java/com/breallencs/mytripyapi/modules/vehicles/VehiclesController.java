package com.breallencs.mytripyapi.modules.vehicles;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/vehicles"})
public class VehiclesController {
  
  private VehicleRepository vehicleRepository;

  public VehiclesController(VehicleRepository vehicleRepository){
    this.vehicleRepository = vehicleRepository;
  }

  @GetMapping
  public List<Vehicles> getAllVehicles(){
    return vehicleRepository.findAll();
  }
}
