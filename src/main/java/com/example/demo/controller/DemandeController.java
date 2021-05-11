package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.repository.DemandeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/demande")
public class DemandeController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	
	//set demande
	
	@PostMapping("/")
	public Demande addDemande(@RequestBody Demande demande) {
		return demandeRepository.save(demande);
	}
	
	//get all demandes
	
	@GetMapping("/get")
	public List<Demande> getAllDemande(){
		return demandeRepository.findAll();
	}
	
	//get demande by id
	
	@GetMapping("/{id}")
	public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
		return ResponseEntity.ok(demande);
	}
	
	//change etat
	
	@PutMapping("/{id}")
	public ResponseEntity<Demande> updateDemande(@PathVariable Long id, String newEtat){
		Demande demande = demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			demande.setEtat(newEtat);
			Demande newDemande = demandeRepository.save(demande);
			return ResponseEntity.ok(newDemande);
	}
	
	
}
