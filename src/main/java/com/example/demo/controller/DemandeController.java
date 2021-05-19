package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Demande> updateDemande(@PathVariable Long id,@RequestBody Demande NewDemande){
		Demande demande = demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			demande.setDate_D(NewDemande.getDate_D());
			demande.setDegre_urgence(NewDemande.getDegre_urgence());
			demande.setDescription(NewDemande.getDescription());
			demande.setDestinataire(NewDemande.getDestinataire());
			demande.setEtat(NewDemande.getEtat());
			demande.setId(NewDemande.getId());
			demande.setLieu(NewDemande.getLieu());
			
			Demande newDemande = demandeRepository.save(demande);
			return ResponseEntity.ok(newDemande);
	}
	
	//demande_test_responsable
	@GetMapping("/demanderes")
	public List<Demande> getAllDemandeRes(){
		List<Demande> demandeOld = demandeRepository.findAll();
		List<Demande> demandeNew = demandeRepository.findAll();
		for(int i=0; i<demandeOld.size(); i++) {
			if(demandeOld.get(i).isAccord_responsable()==true) {
				demandeNew.remove(demandeOld.get(i));
			}
		}
		return demandeNew;

		}
	
	//demande_test_DMG
		@GetMapping("/demandedmg")
		public List<Demande> getAllDemandedmg(){
			List<Demande> demandeOld = demandeRepository.findAll();
			List<Demande> demandeNew = demandeRepository.findAll();
			
			for(int i=0; i<demandeOld.size(); i++) {
				if(demandeOld.get(i).isAccord_responsable()==false || demandeOld.get(i).isAccord_dmg()==true) {
					demandeNew.remove(demandeOld.get(i));
				}
			}
			return demandeNew;
			}
		
		//Set accord_res
		@PutMapping("/accordres/{id}")
		public ResponseEntity<Demande> updateAccordRes(@PathVariable long id,@RequestBody Demande NewDemande){
			
			Demande demande = demandeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
					demande.setDate_D(NewDemande.getDate_D());
					demande.setDegre_urgence(NewDemande.getDegre_urgence());
					demande.setDescription(NewDemande.getDescription());
					demande.setDestinataire(NewDemande.getDestinataire());
					demande.setEtat(NewDemande.getEtat());
					demande.setId(NewDemande.getId());
					demande.setLieu(NewDemande.getLieu());
					demande.setAccord_responsable(true);
					
					Demande newDemande = demandeRepository.save(demande);
					return ResponseEntity.ok(newDemande);
		}
		
		
		
		
		
		//set accord_dmg
		@PutMapping("/accorddmg/{id}")
		public ResponseEntity<Demande> updateAccordDmg(@PathVariable long id,@RequestBody Demande NewDemande){
			
			Demande demande = demandeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
					demande.setDate_D(NewDemande.getDate_D());
					demande.setDegre_urgence(NewDemande.getDegre_urgence());
					demande.setDescription(NewDemande.getDescription());
					demande.setDestinataire(NewDemande.getDestinataire());
					demande.setEtat(NewDemande.getEtat());
					demande.setId(NewDemande.getId());
					demande.setLieu(NewDemande.getLieu());
					demande.setAccord_dmg(true);
					
					Demande newDemande = demandeRepository.save(demande);
					return ResponseEntity.ok(newDemande);
		}
		
		
		
		
		//delete demande
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
			Demande demande = demandeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			demandeRepository.delete(demande);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
}

