package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;
import java.util.List;

import com.breallencs.mytripyapi.modules.expenses.Expenses;
import com.breallencs.mytripyapi.modules.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

  private Double totalBudget;

  private Double totalExpenses;

  private LocalDate startDate;

  private LocalDate endDate;

  private boolean isCurrent;

  @ManyToOne
  private User user;

  @OneToMany(mappedBy = "week", fetch = FetchType.EAGER)
  private List<Expenses> expenses;
}
