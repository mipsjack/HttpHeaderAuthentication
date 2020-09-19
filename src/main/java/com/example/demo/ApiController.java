package com.example.demo;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@GetMapping("header")
	public ResponseEntity<String> whoAmI(Principal principal) {
		return ResponseEntity.ok(principal.getName());
	}

}
