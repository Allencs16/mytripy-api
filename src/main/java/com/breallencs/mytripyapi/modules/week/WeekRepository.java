package com.breallencs.mytripyapi.modules.week;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week, Long>{
  
  List<Week> findByUserId(String userId);

  Optional<Week> findByUserIdAndIsCurrent(Long userId, Boolean isCurrent);
}
