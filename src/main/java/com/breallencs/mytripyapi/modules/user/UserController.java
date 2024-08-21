package com.breallencs.mytripyapi.modules.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.enums.UserType;
import com.breallencs.mytripyapi.services.RedisCacheService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping({"/user"})
public class UserController {

  final UserRepository userRepository;
  final UserService userService;
  private RedisCacheService cacheService;

  public UserController(UserRepository userRepository, UserService userService, RedisCacheService redisCacheService) {
    this.userRepository = userRepository;
    this.userService = userService;
    this.cacheService = redisCacheService;
  }
  
  @GetMapping(path = "/{userName}")
  public User findByUsername(@PathVariable String userName){
    return userRepository.findByUsername(userName).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
  }

  @GetMapping
  public List<User> findAll(){
    return userRepository.findAll();
  }

  @GetMapping("/cache")
  public ResponseEntity<?> getuserInfoFromCache() {
    Object value = cacheService.get("user");
    return value != null ? ResponseEntity.ok(value) : ResponseEntity.notFound().build();
  }
  

  @GetMapping(path = "/tipoUsuario/{userType}")
  public List<User> findByUserType(@PathVariable UserType userType){
    return userRepository.findUserByUserType(userType);
  }

  @GetMapping(path = "/tipoUsuario/{userType}/ativo")
  public List<User> findByUserTypeAndActive(@PathVariable UserType userType){
    return userRepository.findUserByUserTypeAndActive(userType, true);
  }

  @PutMapping(path = "/editar")
  public User editUser(@RequestBody UserDTO userDTO){
    return userService.editUser(userDTO);
  }

  @PutMapping(path = "/activate/{userId}")
  public User activateUser(@PathVariable Long userId, @RequestBody boolean isActive){
    return userService.activateUser(userId, isActive);
  }

  @DeleteMapping(path = "/{id}")
  public User deleteUser(@PathVariable Long id){
    User user = userRepository.findById(id);
    userRepository.delete(user);
    return user;
  }
  
}
