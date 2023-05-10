package com.breallencs.mytripyapi.modules.budget;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    Week week = weekRepository.findById(budgetDTO.getWeekId()).get();

    Budget budget = new Budget();

    budget.setType(budgetDTO.getType());
    budget.setValue(budgetDTO.getValue());
    budget.setWeek(week);

    week.setBudget(budgetTotal + budgetDTO.getValue());
    week.setTotalPrice(budgetTotal + budgetDTO.getValue());

    weekRepository.save(week);

    return budgetRepository.saveAndFlush(budget);
  }

  @Override
  public ResponseEntity<?> deleteBudget(BudgetDTO budgetDTO) {
    Double budgetTotal = budgetRepository.totalByWeek(budgetDTO.getWeekId());
    Week week = weekRepository.findById(budgetDTO.getWeekId()).get();
    week.setBudget(budgetTotal);
    budgetRepository.deleteById(budgetDTO.getId());
    return ResponseEntity.ok().body("Deleted sucefully");
  }
  
}
