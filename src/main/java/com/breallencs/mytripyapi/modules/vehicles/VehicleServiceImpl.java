package com.breallencs.mytripyapi.modules.vehicles;

import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

  private VehicleRepository vehicleRepository;

  public VehicleServiceImpl(VehicleRepository vehicleRepository){
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Vehicles createNewVehicle(VehicleDTO vehicleDTO) {
    Vehicles vehicles = new Vehicles();

    vehicles.setBrand(vehicleDTO.getBrand());
    vehicles.setKmAveragePerLiter(vehicleDTO.getKmAveragePerLiter());
    vehicles.setMaxDistance(vehicleDTO.getMaxDistance());
    vehicles.setName(vehicleDTO.getName());
    vehicles.setPrice(vehicleDTO.getPrice());

    vehicleRepository.saveAndFlush(vehicles);

    return vehicles;
  }

  @Override
  public Vehicles editVehicle(Long id, VehicleDTO vehicleDTO) {
    Vehicles vehicles =  vehicleRepository.findById(id).get();

    vehicles.setBrand(vehicleDTO.getBrand());
    vehicles.setKmAveragePerLiter(vehicleDTO.getKmAveragePerLiter());
    vehicles.setMaxDistance(vehicleDTO.getMaxDistance());
    vehicles.setName(vehicleDTO.getName());
    vehicles.setPrice(vehicleDTO.getPrice());

    vehicleRepository.saveAndFlush(vehicles);

    return vehicles;
  }
  
}
