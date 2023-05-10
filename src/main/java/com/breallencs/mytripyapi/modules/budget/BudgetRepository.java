package com.breallencs.mytripyapi.modules.budget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long>, BudgetRepositoryCustom {
  
}
