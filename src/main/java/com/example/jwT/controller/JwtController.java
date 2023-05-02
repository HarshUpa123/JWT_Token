package com.example.jwT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwT.helper.JwtUtil;
import com.example.jwT.model.JwtEntity;
import com.example.jwT.model.JwtResponse;
import com.example.jwT.service.CustomUserDetailsService;

@RestController
public class JwtController {

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManger;
	
//	@PermitAll
//    @RequestMapping("/JwtController")    
	@PostMapping("/token")  
	public ResponseEntity<?> generateToken(@RequestBody JwtEntity jwtEntity) throws Exception {
		System.out.println(jwtEntity);
		try {
			this.authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(jwtEntity.getusername(), jwtEntity.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad credentials");

		}
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtEntity.getusername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" + token);

		return ResponseEntity.ok(new JwtResponse(token));

	}
}
