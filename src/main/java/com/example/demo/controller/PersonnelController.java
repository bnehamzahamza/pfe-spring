package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.PersonnelRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
	
	@Autowired
	private PersonnelRepository personnelRepository;

}
