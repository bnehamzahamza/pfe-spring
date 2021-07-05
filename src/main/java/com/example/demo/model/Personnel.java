package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="personnel")
public class Personnel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="specialite")
	private String specialite;
	@Column(name="nbre_heure")
	private double nbre_heure;
	@Column(name = "prix")
	private double prix;
	
	
	public Personnel() {
		
	}
	
	public Personnel(long id, String specialite, double nbre_heure, double prix) {
		super();
		this.id = id;
		this.specialite = specialite;
		this.nbre_heure = nbre_heure;
		this.prix = prix;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public double getNbre_heure() {
		return nbre_heure;
	}

	public void setNbre_heure(double nbre_heure) {
		this.nbre_heure = nbre_heure;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
