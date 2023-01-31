package com.breallencs.mytripyapi.modules.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String>{

  UserDetails findByUsername(String userName);

  User findById(Long id);

  Optional<User> findByEmail(String email);

  //UserDetails findByUsername(String subject);
  
}
