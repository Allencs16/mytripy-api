package com.breallencs.mytripyapi.modules.expenses;

import java.time.LocalDateTime;

import com.breallencs.mytripyapi.modules.week.Week;
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
@Table(name = "EXPENSES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expenses {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;

  private Double value;

  private LocalDateTime expenseDate;

  @ManyToOne
  @JsonBackReference
  private Week week;
}
