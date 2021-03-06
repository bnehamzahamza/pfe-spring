package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materiel")
public class Materiel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="nom")
	private String nom;
	@Column(name="qte")
	private double qte;
	@Column(name = "prix")
	private double prix;
	
	
	public Materiel() {
		
	}
	
	public Materiel(long id, String nom, double qte, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.qte = qte;
		this.prix = prix;
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

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
