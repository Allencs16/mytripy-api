package com.breallencs.mytripyapi.modules.budget;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.enums.BudgetCategory;
import com.breallencs.mytripyapi.modules.week.Week;
import com.breallencs.mytripyapi.modules.week.WeekRepository;

@Service
public class BudgetServiceImpl implements BudgetService{

  private WeekRepository weekRepository;
  private BudgetRepository budgetRepository;

  public BudgetServiceImpl(BudgetRepository budgetRepository, WeekRepository weekRepository){
    this.budgetRepository = budgetRepository;
    this.weekRepository = weekRepository;
  }

  @Override
  public Budget createBudget(BudgetDTO budgetDTO) {
    
    Double budgetTotal = budgetRepository.totalByWeek(budgetDTO.getWeekId());

    Week week = weekRepository.findById(budgetDTO.getWeekId()).orElseThrow(() -> new IllegalArgumentException("Não encontrado"));

    Budget budget = new Budget();

    budget.setType(BudgetCategory.verifyCategory(budgetDTO.getType()));
    budget.setValue(budgetDTO.getValue());
    budget.setWeek(week);

    week.setTotalBudget(week.getTotalBudget() + budgetDTO.getValue());
    week.setTotalPrice(budgetTotal + budgetDTO.getValue());

    weekRepository.save(week);

    return budgetRepository.saveAndFlush(budget);
  }

  @Override
  public ResponseEntity<?> deleteBudget(Budget budget) {
    Double budgetTotal = budgetRepository.totalByWeek(budget.getWeek().getId());
    Week week = weekRepository.findById(budget.getWeek().getId()).get();
    week.setTotalBudget(budgetTotal - budget.getValue());
    week.setTotalPrice(week.getTotalPrice() - budget.getValue());
    budgetRepository.deleteById(budget.getId());
    return ResponseEntity.ok().body("Deleted sucefully");
  }

  @Override
  public Budget editBudget(BudgetDTO budgetDTO) {
    Budget budget = budgetRepository.findById(budgetDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Budget not found"));
    Week week = weekRepository.findById(budgetDTO.getWeekId()).get();

    week.setTotalBudget(week.getTotalBudget() - budget.getValue());
    week.setTotalPrice(week.getTotalPrice() - budget.getValue());

    budget.setType(BudgetCategory.verifyCategory(budgetDTO.getType()));
    budget.setValue(budgetDTO.getValue());

    week.setTotalBudget(week.getTotalBudget() + budget.getValue());
    week.setTotalPrice(week.getTotalPrice() + budget.getValue());

    budgetRepository.saveAndFlush(budget);

    return budget;
  }
  
}
