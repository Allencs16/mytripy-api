package com.breallencs.mytripyapi.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

  User findByUserName(String userName);

  User findById(Long id);
  
}
