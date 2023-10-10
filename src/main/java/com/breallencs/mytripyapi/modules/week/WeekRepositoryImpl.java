package com.breallencs.mytripyapi.modules.week;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.breallencs.mytripyapi.modules.user.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class WeekRepositoryImpl implements WeekRepositoryCustom{
  final EntityManager entityManager;

  public WeekRepositoryImpl(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public List<WeekDTO> getAllWeeks() {
    
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<WeekDTO> cq = cb.createQuery(WeekDTO.class);
    Root<Week> week = cq.from(Week.class);

    Join<Week, User> user = week.join("user", JoinType.INNER);

    cq.multiselect(
      week.get("id"),
      week.get("totalPrice"),
      week.get("totalKm"),
      week.get("totalBudget"),
      week.get("totalExpenses"),
      week.get("startDate"),
      week.get("endDate"),
      week.get("isCurrent"),
      user.get("name")
    );

    return entityManager.createQuery(cq).getResultList();
    
  }
  
}
