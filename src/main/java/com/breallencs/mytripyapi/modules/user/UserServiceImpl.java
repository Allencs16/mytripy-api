package com.breallencs.mytripyapi.modules.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.enums.UserType;

@Service
public class UserServiceImpl implements UserService{

  final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public User editUser(UserDTO userDTO) {
    User userFromDatabase = userRepository.findById(userDTO.getId());

    userFromDatabase.setUpdatedAt(LocalDateTime.now());
    userFromDatabase.setUserType(userDTO.getUserType());
    userFromDatabase.setName(userDTO.getName());
    userFromDatabase.setIsActive(userDTO.isUserActive());

    userRepository.saveAndFlush(userFromDatabase);

    return userFromDatabase;
  }

  @Override
  public User activateUser(Long userId, boolean isActive) {
    User userFromDatabase = userRepository.findById(userId);

    userFromDatabase.setIsActive(isActive);

    userRepository.saveAndFlush(userFromDatabase);

    return userFromDatabase;
  }
  
}
