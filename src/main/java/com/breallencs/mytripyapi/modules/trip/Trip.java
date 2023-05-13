package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;

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

  private String name;

  private String description;

  private String state;

  private Double distanceFromSource;

  private Double price;

  private String place;

  private Double food;

  private LocalDate startDay;

  private LocalDate endDay;
  
  @OneToOne
  @JsonBackReference
  private User user;

  @OneToOne
  private Week week;

  @OneToOne
  private Stays stays;

  @OneToOne
  private Vehicles vehicle;
}