package com.breallencs.mytripyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  public void save(String key, Object value) {
    redisTemplate.opsForValue().set(key, value);
  }
  
  public Object get(String key) {
      return redisTemplate.opsForValue().get(key);
  }
  
  public void delete(String key) {
      redisTemplate.delete(key);
  }
}
