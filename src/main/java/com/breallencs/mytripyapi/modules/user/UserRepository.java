package com.breallencs.mytripyapi.modules.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.breallencs.mytripyapi.enums.UserType;

public interface UserRepository extends JpaRepository<User, String>{

  Optional<User> findByUsername(String userName);

  User findById(Long id);

  Optional<User> findByEmail(String email);

  List<User> findUserByUserType(UserType userType);

  List<User> findUserByUserTypeAndActive(UserType userType, boolean active);
  
}
