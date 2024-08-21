package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;
import java.util.List;

import com.breallencs.mytripyapi.modules.expenses.Expenses;
import com.breallencs.mytripyapi.modules.user.User;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekDTO {

  private Long id;
  private Double totalPrice;
  private Double totalKm;
  private Double totalBudget;
  private Double totalExpenses;
  private LocalDate startDate;
  private LocalDate endDate;
  private boolean isCurrent;
  private String userName;
  private Long userId;

  public WeekDTO(Long id, Double totalPrice, Double totalKm, Double totalBudget, Double totalExpenses,
      LocalDate startDate, LocalDate endDate, boolean isCurrent, String user) {
    this.id = id;
    this.totalPrice = totalPrice;
    this.totalKm = totalKm;
    this.totalBudget = totalBudget;
    this.totalExpenses = totalExpenses;
    this.startDate = startDate;
    this.endDate = endDate;
    this.isCurrent = (LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(endDate));
    this.userName = user;
  }
}
