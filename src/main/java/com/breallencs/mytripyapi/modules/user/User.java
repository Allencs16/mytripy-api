package com.breallencs.mytripyapi.modules.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.breallencs.mytripyapi.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user", schema = "public")
@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Boolean cacheData;

  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  @JsonIgnore
  private String password;
  
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Boolean active;

  private UserType userType;

}
