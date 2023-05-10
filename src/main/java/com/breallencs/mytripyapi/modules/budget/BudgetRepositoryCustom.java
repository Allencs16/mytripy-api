package com.breallencs.mytripyapi.modules.budget;

import java.util.List;

public interface BudgetRepositoryCustom {
  
  List<BudgetDTO> getByWeek(Long weekId);

  Double totalByWeek(Long weekId);
}
