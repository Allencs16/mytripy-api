package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping({"/user/{id}"})
  public List<Trip> getTripsByUserId(@PathVariable Long id){
    return tripRepository.findByUserId(id);
  }

  @PostMapping()
  public Trip createTrip(@RequestBody TripDto tripDto){
    Trip trip = new Trip();
    trip.setPlace(tripDto.getPlace());
    trip.setUser(userRepository.findById(tripDto.getIdUser()));
    trip.setCreatedAt(LocalDateTime.now());
    trip.setCoordinates(tripDto.getCoordinates());
    trip.setDescription(tripDto.getDescription());
    trip.setPrice(tripDto.getPrice());
    tripRepository.saveAndFlush(trip);
    return trip;
  }

  @DeleteMapping({"/{id}"})
  public ResponseEntity<?> deleteTrip(@PathVariable Long id){
    return tripRepository.findById(id).map(record -> {
      tripRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
