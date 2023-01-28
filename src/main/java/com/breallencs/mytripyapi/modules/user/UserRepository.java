package com.breallencs.mytripyapi.modules.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

  User findByUsername(String userName);

  User findById(Long id);

  Optional<User> findByEmail(String email);
  
}
