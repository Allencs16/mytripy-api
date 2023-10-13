package com.breallencs.mytripyapi.modules.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.enums.UserType;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping({"/public/user"})
public class UserPublicController {
  
  private UserRepository userRepository;

  UserPublicController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @PostMapping(value="/create")
  public User createUser(@RequestBody UserDTO user) {

    BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
    User userNew = new User();
    userNew.setUsername(user.getUsername());
    userNew.setPassword(bc.encode(user.getPassword()));
    userNew.setEmail(user.getEmail());
    userNew.setName(user.getName());
    userNew.setCreatedAt(LocalDateTime.now());
    userNew.setIsActive(false);

    if(user.getUserType() == null){
      userNew.setUserType(UserType.VIAJANTE);
    }

    userRepository.saveAndFlush(userNew);
    
    return userNew;
  }
  
}
