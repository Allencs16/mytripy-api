package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDateTime;

import com.breallencs.mytripyapi.modules.stays.Stays;
import com.breallencs.mytripyapi.modules.user.User;
import com.breallencs.mytripyapi.modules.vehicles.Vehicles;
import com.breallencs.mytripyapi.modules.week.Week;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trip", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private String state;

  private Double distanceFromSource;

  private Float price;

  private String place;

  private LocalDateTime startDay;

  private LocalDateTime endDay;
  
  @ManyToOne
  @JsonBackReference
  private User user;

  @ManyToOne
  private Week week;

  @OneToOne
  private Stays stays;

  @OneToOne
  private Vehicles vehicle;
}