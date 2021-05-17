package com.example.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name = "mdp")
	private String mdp;
	@Column(name = "login")
	private String login;
	
	@OneToMany(targetEntity  = Demande.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id",referencedColumnName = "id")
	private List<Demande> emp_id;
	
	
	public Employee() {
		
		
	}


	public Employee(long id, String nom, String prenom, String departement, String poste, String mdp, String login,
			List<Demande> emp_id) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.poste = poste;
		this.mdp = mdp;
		this.login = login;
		this.emp_id = emp_id;
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


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public List<Demande> getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(List<Demande> emp_id) {
		this.emp_id = emp_id;
	}


	
	
	
}