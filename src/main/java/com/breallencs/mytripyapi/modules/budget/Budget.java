package com.breallencs.mytripyapi.modules.budget;

import com.breallencs.mytripyapi.enums.BudgetCategory;
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
@Data
@Table(name = "BUDGET")
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BudgetCategory type;

  private Double value;

  @ManyToOne
  @JsonBackReference
  private Week week;
}
