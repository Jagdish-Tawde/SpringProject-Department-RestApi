package com.tutorial.Springproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

	@GetMapping("/")
	public String helloWorld() {
		return "welcome to res api!!";
	}
	
}
