package com.breallencs.mytripyapi.modules.expenses;

import org.springframework.stereotype.Service;

@Service
public interface ExpensesServices {
  
  Expenses createExpense(ExpensesDTO expensesDTO);
}
