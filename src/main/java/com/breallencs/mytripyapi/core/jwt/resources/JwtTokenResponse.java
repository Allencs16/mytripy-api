package com.breallencs.mytripyapi.core.jwt.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class JwtTokenResponse {
  private String token;
}
