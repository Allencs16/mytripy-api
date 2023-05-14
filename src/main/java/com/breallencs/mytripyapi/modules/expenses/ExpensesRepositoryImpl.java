package com.breallencs.mytripyapi.modules.expenses;

import org.springframework.stereotype.Repository;

import com.breallencs.mytripyapi.modules.week.Week;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class ExpensesRepositoryImpl implements ExpensesRepositoryCustom{

  EntityManager entityManager;

  public ExpensesRepositoryImpl(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public Double totalByWeek(Long weekId) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Double> cq = cb.createQuery(Double.class);
    Root<Expenses> expenses = cq.from(Expenses.class);

    Join<Expenses, Week> week = expenses.join("week", JoinType.INNER);

    cq.where(cb.equal(week.get("id"), weekId));

    cq.select(
      cb.sumAsDouble(expenses.get("value"))
    );

    Double total = entityManager.createQuery(cq).getSingleResult();


    return total == null ? 0 : total;
    
  }
  
}
