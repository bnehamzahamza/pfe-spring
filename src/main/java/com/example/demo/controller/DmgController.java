package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dmg;
import com.example.demo.repository.DmgRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dmg")
public class DmgController {

	@Autowired
	private DmgRepository dmgRepository;
	
	@GetMapping("/get/")
	public dmg TestLog(@RequestParam(name = "log") String login, String mdp ) {
		return dmgRepository.findByLoginAndMdp(login, mdp);
	}
	
}
