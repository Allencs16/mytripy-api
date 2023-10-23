package com.breallencs.mytripyapi.modules.trip;

import java.time.LocalDate;
import java.util.List;

import com.breallencs.mytripyapi.modules.user.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class TripRepositoryImpl implements TripRepositoryCustom{
  EntityManager entityManager;

  public TripRepositoryImpl(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public List<Trip> getByUserAndStartDay(Long userId, LocalDate startDay) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Trip> cq = cb.createQuery(Trip.class);
    Root<Trip> trip = cq.from(Trip.class);

    Join<Trip, User> user = trip.join("user", JoinType.INNER);

    cq.where(
      cb.equal(trip.get("startDay"), startDay),
      cb.equal(user.get("id"), userId)
    );

    return entityManager.createQuery(cq).getResultList();
  }
  
}
