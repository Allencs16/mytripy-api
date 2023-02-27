package com.breallencs.mytripyapi.modules.friends;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/friends"})
public class FriendsController {
  
  private FriendsRepository friendsRepository;

  FriendsController(FriendsRepository friendsRepository){
    this.friendsRepository = friendsRepository;
  }

  @GetMapping({"/{id}"})
  public Friends getFriends(@PathVariable Long id){
    return friendsRepository.findByUser1_Id(id);
  }
}
