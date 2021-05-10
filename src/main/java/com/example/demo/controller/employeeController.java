package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/login")
	public List<Employee> LogIn(String login,String mdp) {
		return  EmployeeRepository.findByLoginAndMdp(login, mdp);
	}
	




	
}
