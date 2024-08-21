package com.breallencs.mytripyapi.modules.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.enums.UserType;
import com.breallencs.mytripyapi.services.RedisCacheService;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping({"/public/user"})
public class UserPublicController {
  
  private UserRepository userRepository;
  
  private RedisCacheService redisCacheService;

  UserPublicController(UserRepository userRepository, RedisCacheService redisCacheService){
    this.userRepository = userRepository;
    this.redisCacheService = redisCacheService;
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
    userNew.setActive(false);
    userNew.setCacheData(true);

    if(user.getUserType() == null){
      userNew.setUserType(UserType.VIAJANTE);
    }

    redisCacheService.save("user", userNew);

    userRepository.saveAndFlush(userNew);
    
    return userNew;
  }
  
}
