package com.breallencs.mytripyapi.modules.trip;

import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.modules.user.UserRepository;
import com.breallencs.mytripyapi.modules.vehicles.VehicleRepository;
import com.breallencs.mytripyapi.modules.week.Week;
import com.breallencs.mytripyapi.modules.week.WeekRepository;

@Service
public class TripServiceImpl implements TripService{

  private TripRepository tripRepository;
  private UserRepository userRepository;
  private WeekRepository weekRepository;
  private VehicleRepository vehicleRepository;

  public TripServiceImpl(TripRepository tripRepository, UserRepository userRepository, WeekRepository weekRepository, VehicleRepository vehicleRepository){
    this.tripRepository = tripRepository;
    this.userRepository = userRepository;
    this.weekRepository = weekRepository;
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Trip createTrip(TripDto tripDto) {

    Week week = weekRepository.findById(tripDto.getWeekId()).get();

    if (week.getTotalKm() == null) {
      week.setTotalKm(0.0);
    }
    week.setTotalKm(week.getTotalKm() + tripDto.getDistanceFromSource());

    Trip trip = new Trip();
    trip.setWeek(week);
    trip.setUser(userRepository.findById(tripDto.getUserId()));
    trip.setVehicle(vehicleRepository.findById(tripDto.getVehicleId()).get());
    trip.setDescription(tripDto.getDescription());
    trip.setDistanceFromSource(tripDto.getDistanceFromSource());
    trip.setPlace(tripDto.getPlace());
    trip.setFood(tripDto.getFood());
    trip.setPrice(tripDto.getPrice());
    trip.setState(tripDto.getState());
    trip.setName(tripDto.getName());

    tripRepository.saveAndFlush(trip);
    
    return trip;
  }
  
}
