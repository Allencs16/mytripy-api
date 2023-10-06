package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;
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
  private TripService tripService;

  TripController(TripRepository tripRepository, UserRepository userRepository, TripService tripService){
    this.tripRepository = tripRepository;
    this.userRepository = userRepository;
    this.tripService = tripService;
  }
  
  @GetMapping
  public List<Trip> getTrips(){
    return tripRepository.findAll();
  }

  @GetMapping({"/user/{id}"})
  public List<Trip> getTripsByUserId(@PathVariable Long id){
    return tripRepository.findByUserId(id);
  }

  @GetMapping({"/totalKm"})
  public TripQuantitativesDTO getTotalKmByMonth(){
    return tripService.totalKmByMonth();
  }

  @GetMapping({"/user/{id}/{date}"})
  public Trip getTripByDateAndUser(@PathVariable Long id, @PathVariable LocalDate date){
    return tripRepository.getByUserAndStartDay(id, date);
  }

  @PostMapping()
  public ResponseEntity<?> createTrip(@RequestBody TripDto tripDto){
    return tripService.createTrip(tripDto);
  }

  @DeleteMapping({"/{id}"})
  public ResponseEntity<?> deleteTrip(@PathVariable Long id){
    return tripRepository.findById(id).map(record -> {
      tripRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
