package com.breallencs.mytripyapi.modules.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;
  
  private LocalDateTime CreatedAt;

  private Boolean isActive;

  public User(String name, String username, String email, String password, LocalDateTime createdAt, Boolean isActive) {
    super();
    this.id = 0L;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    CreatedAt = createdAt;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getCreatedAt() {
    return CreatedAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    CreatedAt = createdAt;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(CreatedAt, user.CreatedAt) && Objects.equals(isActive, user.isActive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, username, email, password, CreatedAt, isActive);
  }

}
