package com.breallencs.mytripyapi.modules.week;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week, String>{
  
  List<Week> findByUserId(String userId);
}
