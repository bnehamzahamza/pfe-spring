package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.model.Employee;
import com.example.demo.model.Responsable;
import com.example.demo.repository.ResponsableRepository;
import java.util.List;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/responsable")
public class ResponsableController {

	
	@Autowired
	private ResponsableRepository responsablerepository;
	
	
	@GetMapping("/")
	public  List<Responsable>GetAllRes(){
		return responsablerepository.findAll();
	}
	
	
	@PostMapping("/setdemande")
	public Responsable setDemande(@RequestBody Employee emp) {
		String Dep = emp.getDepartement();
		Responsable res = responsablerepository.findByDepartement(Dep);
		res.setRes_id(emp.getEmp_id());
		return responsablerepository.save(res);
	}
	
	@PostMapping("/set")
	public Responsable setResponsable(@RequestBody Responsable resp) {
		return responsablerepository.save(resp);
	}
	
	@GetMapping("/getdemande/{id}")
	public List<Demande> getDemandes(@PathVariable long id){
		Responsable res = responsablerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no Responsable with this id"+ id));
		return res.getRes_id();
	}
	
	@GetMapping("/testlog")
	public Responsable testLog(@RequestParam String login,@RequestParam String mdp) {
		Responsable res = responsablerepository.findByLoginAndMdp(login, mdp);
		return res;
	}
	
}
