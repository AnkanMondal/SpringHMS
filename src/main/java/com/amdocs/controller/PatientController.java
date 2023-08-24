package com.amdocs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
	@GetMapping("/")
	public String greetHello() {
		return "Welcome to HMS";
	}
	
}
