package com.breallencs.mytripyapi.modules.vehicles;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping({"/vehicles"})
public class VehiclesController {
  
  private VehicleRepository vehicleRepository;
  private VehicleService vehicleService;

  public VehiclesController(VehicleRepository vehicleRepository, VehicleService vehicleService){
    this.vehicleRepository = vehicleRepository;
    this.vehicleService = vehicleService;
  }

  @GetMapping
  public List<Vehicles> getAllVehicles(){
    return vehicleRepository.findAll();
  }

  @PostMapping
  public Vehicles createVehicle(@RequestBody VehicleDTO vehicleDTO){
    return vehicleService.createNewVehicle(vehicleDTO);
  }

  @PutMapping(value="/{vehicleId}")
  public Vehicles editVehicles(@PathVariable Long vehicleId, @RequestBody VehicleDTO vehicleDTO) {
    return vehicleService.editVehicle(vehicleId, vehicleDTO);
  }
}
