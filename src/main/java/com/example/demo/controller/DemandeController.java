package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Besoins;
import com.example.demo.model.Demande;
import com.example.demo.model.Employee;
import com.example.demo.model.Fourniture;
import com.example.demo.model.Materiel;
import com.example.demo.model.Personnel;
import com.example.demo.repository.DemandeRepository;
import com.example.demo.repository.employeeRepository;


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
	
	 public int compare(Demande a, Demande b) {
         return a.getDate_D().compareTo(b.getDate_D());
     }
	
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private employeeRepository EmployeeRepository;
	
	
	
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
		
				demande.setEtat(NewDemande.getEtat());

				
				Demande newDemande = demandeRepository.save(demande);
				return ResponseEntity.ok(newDemande);
	}
	
	//demande_test_responsable
	@PostMapping("/demanderes")
	public List<Demande> getAllDemandeRes(@RequestBody List<Demande> dem){
		List<Demande> demandeNew = new ArrayList<Demande>();
		for(int i=0; i<dem.size(); i++) {
			if(dem.get(i).isAccord_responsable()==false) {
				demandeNew.add(dem.get(i));
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
		
		//get demande by employee id
		@GetMapping("/getbyempid/{id}")
		public ResponseEntity<List<Demande>> getByEmpId(@PathVariable Long id){
			Employee emp = EmployeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no employee with this id"+ id));
			List<Demande> listD = emp.getEmp_id();
			return ResponseEntity.ok(listD);
			
			
		}
		
		//get demande by etat
		@GetMapping("/getbyetat/{etat}")
		public List<Demande> getByEtat(@PathVariable String etat){
		List<Demande> listOld = demandeRepository.findAll();
		List<Demande> listNew = new ArrayList<Demande>();

		for (Demande dem : listOld) {
			if(dem.getEtat().equals(etat))
			listNew.add(dem);
		}
		return listNew;
		
		}
		
		
		@PostMapping("/filtrerbyetat/{etat}")
		public List<Demande> getDemandeFiltre(@RequestBody List<Demande> ListDem ,@PathVariable String etat){
			List<Demande> NewList = new ArrayList<Demande>();
			for(Demande dem : ListDem) {
				if(dem.getEtat().equals(etat)) {
					NewList.add(dem);
				}
			}
			return NewList;
			
		}
		
		//tri 1
		
		@PostMapping("/get/bydateasc")
		public List<Demande> triDemandesByDateAsc(@RequestBody List<Demande> demandes){
			demandes.sort((d1,d2) -> d1.getDate_D().compareTo(d2.getDate_D()));
			return demandes;
		}
		
		//tri 2
		
		@PostMapping("get/bydatedesc")
		public List<Demande> triDemandeByDateDes(@RequestBody List<Demande> demandes){
			demandes.sort((d1,d2) -> d1.getDate_D().compareTo(d2.getDate_D()));
			Collections.reverse(demandes);
			return demandes;
		}
		

		//tri 3
		@PutMapping("get/couts")
		public Demande getCouts(@RequestBody Besoins besoin) {
			List<Fourniture> ListF = besoin.getBesoinsF_id();
			List<Materiel> ListM = besoin.getBesoinsM_id();
			List<Personnel> ListP = besoin.getBesoinsP_id();
			double FraisF = 0.0;
			double FraisP = 0.0;
			double FraisM = 0.0;
			
			for (Fourniture fr : ListF) {
				FraisF += fr.getPrix()*fr.getQte();
			}
			for (Materiel mt : ListM) {
				FraisM += mt.getPrix()*mt.getQte();
			}
			for (Personnel pr : ListP) {
				FraisP += pr.getNbre_heure()*pr.getPrix();
			}
			
			Number Totale = FraisM+FraisF+FraisP;
			besoin.getDemande_id().setFrais(Totale);
			
			return demandeRepository.save(besoin.getDemande_id());
		}
		
		//tri 4
		@GetMapping("get/bydep")
		public List<Demande> getByDep(@RequestParam String dep){
			List<Demande> ListD = new ArrayList<Demande>();
			List<Employee> ListE = EmployeeRepository.findAllByDepartement(dep);
			for (Employee emp : ListE) {
				for (Demande DemEmp : emp.getEmp_id()) {
					ListD.add(DemEmp);
				}
			}
			return ListD;
		}
		
		
		
}

