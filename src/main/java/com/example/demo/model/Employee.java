package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	private long Id;
	@Column(name ="nom")
	private String Nom; 
	@Column(name ="prenom")
	private String Prenom; 
	@Column(name ="departement")
	private String Departement; 
	@Column(name = "poste")
	private String Post;
	
	public Employee() {
		
		
	}
	
	public Employee(long id, String nom, String prenom, String departement, String post) {
		super();
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Departement = departement;
		Post = post;
	}
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getDepartement() {
		return Departement;
	}
	public void setDepartement(String departement) {
		Departement = departement;
	}
	public String getPost() {
		return Post;
	}
	public void setPost(String post) {
		Post = post;
	}
	
	
	
	
	
}
