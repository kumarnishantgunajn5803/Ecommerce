package com.application.Config;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		 if(authentication!=null) {
			 
			SecretKey secretKey =Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
			
			String jwt = Jwts.builder()
					 .setIssuer("Nishant")
			         .setSubject("JWT Token")
			         .claim("username", authentication.getName())
			         .claim("authorities", getRole(authentication.getAuthorities()))
			         .setIssuedAt(new Date())
			         .setExpiration(new Date(new Date().getTime()+ 300000000))
			         .signWith(secretKey).compact();
			
			
			response.setHeader(SecurityConstant.JWT_HEADER, jwt);
		 }
		 
		 filterChain.doFilter(request, response);
		
	}
//	private String populateAuthority(Collection<? extends GrantedAuthority> collection) {
//		Set<String> authoritiesSet = new HashSet<>();
//		for(GrantedAuthority grantedAuthority:collection) {
//			authoritiesSet.add(grantedAuthority.getAuthority());
//		}
//		
//		return String.join(",", authoritiesSet);
//	}
	
	private String getRole(Collection<? extends GrantedAuthority> collection) {
		String role="";
		for(GrantedAuthority ga:collection) {
			role=ga.getAuthority();
		}
		return role;
	}
	 
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		 
		return !request.getServletPath().equals("/signIn");
	}

}
