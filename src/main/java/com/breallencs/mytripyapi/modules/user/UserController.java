package com.breallencs.mytripyapi.modules.user;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.enums.UserType;

@RestController
@RequestMapping({"/user"})
public class UserController {

  final UserRepository userRepository;
  final UserService userService;

  public UserController(UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
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

  @PutMapping(path = "/editar")
  public User editUser(@RequestBody UserDTO userDTO){
    return userService.editUser(userDTO);
  }

  @DeleteMapping(path = "/{id}")
  public User deleteUser(@PathVariable Long id){
    User user = userRepository.findById(id);
    userRepository.delete(user);
    return user;
  }
  
}
