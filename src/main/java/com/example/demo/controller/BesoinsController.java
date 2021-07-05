package com.example.demo.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Besoins;
import com.example.demo.model.Demande;
import com.example.demo.model.Fourniture;
import com.example.demo.model.Materiel;
import com.example.demo.model.Personnel;
import com.example.demo.repository.BesoinsRepository;
import com.example.demo.repository.DemandeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/besoins")
public class BesoinsController {
	
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
	private BesoinsRepository besoinsRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	
	//set fourniture for newBesoins
	@PostMapping("/setf")
	public Besoins setBesoinsF(@RequestBody Fourniture fourniture) {
		
		ArrayList<Fourniture> listF = new ArrayList<Fourniture>();
		listF.add(fourniture);
		Besoins besoin = new Besoins();
		besoin.setBesoinsF_id(listF);
		return besoinsRepository.save(besoin);
	}
	
	//set demande for Besoins
	@PostMapping("/setd")
	public Besoins setBesoinsD(@RequestBody Besoins besoin,@RequestParam long id) {
		Demande demande = demandeRepository.getOne(id);
		besoin.setDemande_id(demande);
		return besoinsRepository.save(besoin);
		
	}
	
	
	//get besoins by demande id

	@PutMapping("/getdb")
	public Besoins getByDemande(@RequestBody Demande demande) {
		Besoins retBesoin = new Besoins();
		List<Besoins> listBesoins = besoinsRepository.findAll();
		
		for (int i=0; i<listBesoins.size(); i++) {
			
			if(listBesoins.get(i).getDemande_id().getId()==demande.getId()) {
				retBesoin = listBesoins.get(i);
			}
			else {
				
				retBesoin.setDemande_id(demande);
		}
	}
		if(retBesoin.getId()==0) {
			retBesoin.setId(listBesoins.size()+2);
		}
		return retBesoin;
	
}
	
	@PostMapping("/")
	public Besoins setBesoin(@RequestBody Besoins besoins) {
		return besoinsRepository.save(besoins);
		
	}
	

	//get all fournitures by besoin
	@PostMapping("/getf")
	public List<Fourniture> getFournitureByBesoin(@RequestBody Besoins besoin) {
		return besoin.getBesoinsF_id();
	}
	
	//get all matériels by besoin
	@PostMapping("/getm")
	public List<Materiel> getMaterielByBesoin(@RequestBody Besoins besoin){
		return besoin.getBesoinsM_id();
	}
	
	//get all personnel by besoin
		@PostMapping("/getp")
		public List<Personnel> getPersonnelByBesoin(@RequestBody Besoins besoin){
			return besoin.getBesoinsP_id();
		}
	
	//get all besoins
		@GetMapping("/get")
		public List<Besoins> getBesoins (){
			return besoinsRepository.findAll();
		}
	
	//get besoin by id
		@GetMapping("/getbyid/{id}")
		public ResponseEntity<Besoins> getBesoinsById(@PathVariable long id) {
			Besoins besoin = besoinsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			return ResponseEntity.ok(besoin);
			
		}
		
		
	//set fourniture for besoin
		@PutMapping("setfb/{id}")
		public ResponseEntity<Besoins> setFournitureByBesoinsId(@PathVariable long id,@RequestBody Fourniture fourniture){
			Besoins besoin = besoinsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			List<Fourniture> ListF = besoin.getBesoinsF_id();
			ListF.add(fourniture);
			besoin.setBesoinsF_id(ListF);
			Besoins newBesoin = besoinsRepository.save(besoin);
			return ResponseEntity.ok(newBesoin);
		}
		
		
	//set personnel for besoin
		@PutMapping("setpb/{id}")
			public ResponseEntity<Besoins> setPersonnelByBesoinsId(@PathVariable long id,@RequestBody Personnel personnel){
			Besoins besoin = besoinsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			List<Personnel> ListP = besoin.getBesoinsP_id();
			ListP.add(personnel);
			besoin.setBesoinsP_id(ListP);
			Besoins newBesoin = besoinsRepository.save(besoin);
			return ResponseEntity.ok(newBesoin);
		}
		
	//set materiel for besoin
		@PutMapping("setmb/{id}")
		public ResponseEntity<Besoins> setMaterielByBesoinsId(@PathVariable long id,@RequestBody Materiel materiel){
			Besoins besoin = besoinsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no demande with this id"+ id));
			List<Materiel> ListM = besoin.getBesoinsM_id();
			ListM.add(materiel);
			besoin.setBesoinsM_id(ListM);
			Besoins newBesoin = besoinsRepository.save(besoin);
			return ResponseEntity.ok(newBesoin);
		}
		
		
		@PutMapping("/setdatef/")
		public ResponseEntity<Besoins> setDateF(@RequestParam long id,@RequestBody Besoins besoin) {
			Besoins besoinOld = besoinsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("no besoin with this id"+ id));
			besoinOld.setDate_F(besoin.getDate_F());
			
			Besoins newBesoin = besoinsRepository.save(besoinOld);
			return ResponseEntity.ok(newBesoin);
		}
		
		@GetMapping("/datediff")
		public long dateDiff(@RequestParam(name = "date1") Date firstDate ,@RequestParam(name = "date2") Date secondDate ) {
			long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		    return diff;
		}
		
		
		//get fournitures costs
		@PostMapping("/getfrcost")
		public double frCosts(@RequestBody Besoins bes) {
			List<Fourniture> ListFr = bes.getBesoinsF_id();
			double FraisTotal = 0;
			for(Fourniture Frnt : ListFr) {
				double frai = Frnt.getPrix()*Frnt.getQte();
				FraisTotal += frai;
			}
			
			return FraisTotal;
		}
		//get fournitures costs
		
		@PostMapping("/getprcost")
		public double PrCosts(@RequestBody Besoins bes) {
			List<Personnel> ListPr = bes.getBesoinsP_id();
			double FraisTotal = 0;
			for(Personnel Frnt : ListPr) {
				double frai = Frnt.getPrix()*Frnt.getNbre_heure();
				FraisTotal += frai;
			}
			
			return FraisTotal;
		}
		//get fournitures costs
		
		@PostMapping("/getmtcost")
		public double MtCosts(@RequestBody Besoins bes) {
			List<Materiel> ListMt = bes.getBesoinsM_id();
			double FraisTotal = 0;
			for(Materiel Frnt : ListMt) {
				double frai = Frnt.getPrix()*Frnt.getQte();
				FraisTotal += frai;
			}
			
			return FraisTotal;
		}
		
		
		
		
		@PostMapping("/tribydate/")
		public Besoins triDate(@RequestParam long dateid,@RequestBody Demande ListDem){
			
			Besoins ListNew = new Besoins();
			List<Besoins> Listbes = besoinsRepository.findAll();
			
			int siz = Listbes.size(); 
				for(int i=0 ; i<siz ; i++) {
					
					if(ListDem.equals(Listbes.get(i).getDemande_id())) {
						ListNew = Listbes.get(i);	
					}
				}
			
			
			return ListNew;
			
			}
			
			

		
		
		
}
