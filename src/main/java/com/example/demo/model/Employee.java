package com.example.demo.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="nom")
	public String nom; 
	@Column(name ="prenom")
	private String prenom; 
	@Column(name ="departement")
	private String departement; 
	@Column(name = "poste")
	private String poste;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="emp")
	private Set<Demande> Ddes;
	
	
	public Employee() {
		
		
	}

	public Employee(long id, String nom, String prenom, String departement, String post) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.poste = post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getPost() {
		return poste;
	}

	public void setPost(String post) {
		this.poste = post;
	}
	
	
	
	
	
}
