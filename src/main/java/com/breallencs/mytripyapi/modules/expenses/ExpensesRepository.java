package com.breallencs.mytripyapi.modules.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long>, ExpensesRepositoryCustom{
  
}
