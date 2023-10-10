package com.breallencs.mytripyapi.modules.expenses;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.enums.BudgetCategory;
import com.breallencs.mytripyapi.modules.week.Week;
import com.breallencs.mytripyapi.modules.week.WeekRepository;

@Service
public class ExpensesServicesImpl implements ExpensesServices{

  private ExpensesRepository expensesRepository;
  private WeekRepository weekRepository;

  public ExpensesServicesImpl(ExpensesRepository expensesRepository, WeekRepository weekRepository){
    this.expensesRepository = expensesRepository;
    this.weekRepository = weekRepository;
  }

  @Override
  public Expenses createExpense(ExpensesDTO expensesDTO) {
    Double totalExpenses = expensesRepository.totalByWeek(expensesDTO.getWeekId());
    Expenses expenses = new Expenses();
    Week week = weekRepository.findById(expensesDTO.getWeekId()).orElseThrow(() -> new IllegalArgumentException("Não Encontrado"));

    if (week.getTotalExpenses() == null) {
      week.setTotalExpenses(totalExpenses);
    } else {
      week.setTotalExpenses(totalExpenses + expensesDTO.getValue());
    }

    week.setTotalBudget(week.getTotalBudget() - expensesDTO.getValue());

    expenses.setExpenseDate(expensesDTO.getExpenseDate());
    expenses.setType(BudgetCategory.verifyCategory(expensesDTO.getType()));
    expenses.setValue(expensesDTO.getValue());
    expenses.setWeek(week);

    expensesRepository.saveAndFlush(expenses);

    return expenses;
  }
  
}
