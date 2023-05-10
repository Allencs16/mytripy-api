package com.breallencs.mytripyapi.modules.budget;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.breallencs.mytripyapi.modules.week.Week;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class BudgetRepositoryImpl implements BudgetRepositoryCustom{

  EntityManager entityManager;

  public BudgetRepositoryImpl(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public List<BudgetDTO> getByWeek(Long weekId) {
    
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<BudgetDTO> cq = cb.createQuery(BudgetDTO.class);
    Root<Budget> budget = cq.from(Budget.class);

    Join<Budget, Week> week = budget.join("week", JoinType.INNER);

    cq.where(cb.equal(week.get("id"), weekId));

    cq.multiselect(
      budget.get("id"),
      budget.get("type"),
      budget.get("value")
    );

    return entityManager.createQuery(cq).getResultList();
  }

  @Override
  public Double totalByWeek(Long weekId) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Double> cq = cb.createQuery(Double.class);
    Root<Budget> budget = cq.from(Budget.class);

    Join<Budget, Week> week = budget.join("week", JoinType.INNER);

    cq.where(cb.equal(week.get("id"), weekId));

    cq.select(
      cb.sumAsDouble(budget.get("value"))
    );

    Double total = entityManager.createQuery(cq).getSingleResult();


    return total == null ? 0 : total;
  }
  
}
