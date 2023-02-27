package com.breallencs.mytripyapi.modules.friends;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Long>{
  
  Friends findByUser1_Id(Long id);
}
