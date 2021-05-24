package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.model.ServiceConcerne;
import com.example.demo.repository.ServiceConcerneRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/serviceconcerne")
public class ServiceConcerneController {

	@Autowired
	private ServiceConcerneRepository serviceConcerneRepository;
	
	@PutMapping("/getnom")
	
	public ResponseEntity<ServiceConcerne>getServiceAdemande(@RequestParam String nom,@RequestBody Demande demande) {
		ServiceConcerne ser = serviceConcerneRepository.findByNom(nom);
		 List<Demande> listDemande = ser.getEmpsc_id();
		 listDemande.add(demande);
		 ser.setEmpsc_id(listDemande);
		ServiceConcerne serv = serviceConcerneRepository.save(ser);
		return ResponseEntity.ok(serv);
	}
	
	
	@GetMapping("/")
	public List<ServiceConcerne> getService() {
		return serviceConcerneRepository.findAll();
	}
	
	
	//return list demandes
	@GetMapping("/liste")
	public List<Demande> getScDemande(@RequestParam long id){
		ServiceConcerne servC = serviceConcerneRepository.getOne(id);
		List<Demande> ListeD = servC.getEmpsc_id();
		return ListeD;
	}
	
}
