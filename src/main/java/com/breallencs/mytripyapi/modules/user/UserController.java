package com.breallencs.mytripyapi.modules.user;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.enums.UserType;

@RestController
@RequestMapping({"/user"})
public class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @GetMapping(path = "/{userName}")
  public User findByUsername(@PathVariable String userName){
    return userRepository.findByUsername(userName).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
  }

  @GetMapping
  public List<User> findAll(){
    return userRepository.findAll();
  }

  @GetMapping(path = "/tipoUsuario/{userType}")
  public List<User> findByUserType(@PathVariable UserType userType){
    return userRepository.findUserByUserType(userType);
  }

  @DeleteMapping(path = "/{id}")
  public User deleteUser(@PathVariable Long id){
    User user = userRepository.findById(id);
    userRepository.delete(user);
    return user;
  }
  
}
