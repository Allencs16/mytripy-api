package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDateTime;

import com.breallencs.mytripyapi.modules.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

  private Boolean isQuiet;

  private Float price;

  private String place;

  private LocalDateTime createdAt;
  
  private String coordinates;
  
  @ManyToOne
  @JsonBackReference
  private User user;
}