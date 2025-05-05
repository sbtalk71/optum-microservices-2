package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.services.HrService;

@RestController
@RequestMapping("/hr")
public class HrController {
	
	private HrService hrService;

	public HrController(HrService hrService) {
		this.hrService = hrService;
	}
	
	@GetMapping(path="/emp/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmpDetails(@PathVariable int id){
		return ResponseEntity.ok(hrService.getEmpDetails(id));
	}
	
}
