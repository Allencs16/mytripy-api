package com.breallencs.mytripyapi.modules.budget;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BudgetService {

  Budget createBudget(BudgetDTO budgetDTO);

  Budget editBudget(BudgetDTO budgetDTO);

  ResponseEntity<?> deleteBudget(Budget budget);
}
