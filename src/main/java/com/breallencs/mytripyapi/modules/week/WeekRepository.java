package com.breallencs.mytripyapi.modules.week;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week, Long>, WeekRepositoryCustom{
  
  List<Week> findByUserId(String userId);

  Optional<Week> findByUserIdAndIsCurrent(Long userId, Boolean isCurrent);

  Optional<Week> findByStartDateAndUserId(LocalDate startDate, Long userId);
}
