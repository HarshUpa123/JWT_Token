package com.example.jwT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/welcome")
	public String welcome() {
		String text = "Hey";
		text += " i am in ";
		return text;
	}
	
	@GetMapping("/getUsers")
	public String getUser() {
		return "{\"name\":\"Harshit\"}";
	}

}
