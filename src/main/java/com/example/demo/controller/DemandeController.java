package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.repository.DemandeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/demande")
public class DemandeController {

	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@PostMapping("/")
	public Demande addDemande(Demande demande) {
		return demandeRepository.save(demande);
	}
	
	@GetMapping("/get")
	public List<Demande> getAllDemande(){
		return demandeRepository.findAll();
	}
}
