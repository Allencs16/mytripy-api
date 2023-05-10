package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WEEK", schema = "public")
public class Week {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double totalPrice;

  private Double totalKm;

  private Double budget;

  private Double expenses;

  private LocalDate startDate;

  private LocalDate endDate;

  private boolean isCurrent;

  @ManyToOne
  private User user;
}
