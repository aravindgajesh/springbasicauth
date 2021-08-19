package com.springauth.check.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/other")
public class OtherController {
	
	@GetMapping("/othergreeting")
	public String getGreeting() {
		return "Hello Spring Security OTHER";
	}
}
