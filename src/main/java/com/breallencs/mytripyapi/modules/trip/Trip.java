package com.breallencs.mytripyapi.modules.trip;

import com.breallencs.mytripyapi.modules.user.User;

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
  private String place;
  
  private String coordinates;
  
  @ManyToOne
  private User usuario;
}