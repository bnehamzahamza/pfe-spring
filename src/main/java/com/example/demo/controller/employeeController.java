package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.model.Employee;
import com.example.demo.repository.employeeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class employeeController {
	
	@Autowired
	private employeeRepository EmployeeRepository;
	
	
	@GetMapping("/")
	public List<Employee> getAllEmployee(){
		return EmployeeRepository.findAll();
	}

	@PostMapping("/login")
	public boolean LogIn(String login, String mdp) {
		Employee emp = EmployeeRepository.findByLoginAndMdp(login, mdp);
		if (emp == null) {
			return false;
		}
		else {return true ;
		}
		
		
		
	}
	
	
	@PostMapping("/set")
	public Employee setEmployee(@RequestBody Employee emp) {
		
		return EmployeeRepository.save(emp);
	}

	
	//add demande to an employee
	
	
	@PutMapping("/setdemande/{id}")
	public Employee  addDemandeEmp(@PathVariable Long id,@RequestBody Demande demNew) {
		Employee empOld = EmployeeRepository.getOne(id);
		List<Demande> testDemande = empOld.getEmp_id();
		testDemande.add(demNew);
		empOld.setEmp_id(testDemande);
		
		
		Employee newEmp = EmployeeRepository.save(empOld);
		return newEmp;
		
	}
	

	
}
