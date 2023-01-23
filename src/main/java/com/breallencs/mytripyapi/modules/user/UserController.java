package com.breallencs.mytripyapi.modules.user;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/user"})
public class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @GetMapping(path = "/{userName}")
  public Optional<User> findByUsername(@PathVariable String userName){
    return userRepository.findByUserName(userName);
  }

  @GetMapping
  public List<User> findAll(){
    return userRepository.findAll();
  }

  @DeleteMapping(path = "/{id}")
  public User deleteUser(@PathVariable Long id){
    User user = userRepository.findById(id);
    userRepository.delete(user);
    return user;
  }
  
}
