package com.breallencs.mytripyapi.modules.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping({"/public"})
public class UserPublicController {
  
  private UserRepository userRepository;

  UserPublicController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @PostMapping(value="/user/create")
  public User createUser(@RequestBody User user) {
    
    User userNew = new User();
    userNew.setPassword(user.getPassword());
    userNew.setEmail(user.getEmail());
    userNew.setName(user.getName());
    userRepository.saveAndFlush(userNew);
    
    return userNew;
  }
  
}
