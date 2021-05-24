package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fourniture;
import com.example.demo.repository.FournitureRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fourniture")
public class FournitureController {

	@Autowired
	private FournitureRepository fournitureRepository;
	
	//set fourniture
	@PostMapping("/set")
	public Fourniture setFourniture(@RequestBody Fourniture frs) {
		return fournitureRepository.save(frs);
	}
	
}
