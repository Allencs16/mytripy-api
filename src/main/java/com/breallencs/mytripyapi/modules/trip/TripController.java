package com.breallencs.mytripyapi.modules.trip;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.modules.user.UserRepository;

@RestController
@RequestMapping({"/trip"})
public class TripController {

  private TripRepository tripRepository;
  private UserRepository userRepository;  

  TripController(TripRepository tripRepository, UserRepository userRepository){
    this.tripRepository = tripRepository;
    this.userRepository = userRepository;
  }
  
  @GetMapping
  public List<Trip> getTrips(){
    return tripRepository.findAll();
  }

  @PostMapping()
  public Trip createTrip(@RequestBody TripDto tripDto){
    Trip trip = new Trip();
    trip.setName(tripDto.getName());
    trip.setPlace(tripDto.getPlace());
    trip.setUser(userRepository.findById(tripDto.getIdUsuario()));
    tripRepository.saveAndFlush(trip);
    return trip;
  }
}
