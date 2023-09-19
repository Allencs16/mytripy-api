package com.breallencs.mytripyapi.core.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.breallencs.mytripyapi.core.jwt.JwtTokenUtil;

import java.io.IOException;
import java.util.Enumeration;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private UserDetailsService jwtUserDetailsService;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Value("${jwt.http.request.header}")
  private String tokenHeader;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
    Enumeration<String> headerNames = request.getHeaderNames();


    if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                    System.out.println("Header: " + request.getHeader(headerNames.nextElement()));
            }
    }
    boolean isPublic = false;
    if(request.getRequestURL().toString().contains("/authenticate")){
      isPublic = true;
    }
    if(request.getRequestURL().toString().contains("/public/user/create")){
      isPublic = true;
    }
    if(!isPublic){
      var token = recuperaToken(request);
      if(token != null){
        var tokenSubject = jwtTokenUtil.getSubject(token);
        var usuario = jwtUserDetailsService.loadUserByUsername(tokenSubject);

        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    
    chain.doFilter(request, response);
  }
 
  private String recuperaToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");
    if(authorizationHeader == null){
      throw new RuntimeException("Token is not present");
    }
    return authorizationHeader.replace("Bearer ", "");
  }

}
