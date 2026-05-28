package com.employeeManagement.config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employeeManagement.model.Employee;
import com.employeeManagement.repository.EmployeeRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
	
		String authHeader = request.getHeader("Authorization");
		
		String token = null;
		String employeeId = null;
		
		if (authHeader != null && 
				authHeader.startsWith("Bearer ")) {
			
			token = authHeader.substring(7);
			employeeId = jwtUtil.extractEmployeeId(token);
		}
		if (employeeId != null && SecurityContextHolder.getContext()
				.getAuthentication() == null) {
			Employee employee = empRepo.findByEmployeeId(employeeId).orElse(null);
			
			if (employee != null && jwtUtil.validateToken(token)) {
				
				List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(
						"ROLE_" + employee.getRole().name()));
				
				UsernamePasswordAuthenticationToken authToken = 
						new UsernamePasswordAuthenticationToken(employee, null, authorities);
				
				authToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
}
