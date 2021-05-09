package com.example.demo.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Demande")
public class Demande {
@Id
private long Id;
@Column(name = "destinataire")
private String destinataire;
@Column(name = "date_D")
private Date date;
@Column(name = "lieu")
private String lieu;
@Column(name = "decription")
private String description;
@Column(name = "degre_urgence")
private String degre_urgence;
@Column(name = "etat")
private String etat;

@ManyToOne
Employee emp;


public long getId() {
	return Id;
}
public void setId(long id) {
	this.Id = id;
}
public String getDestinataire() {
	return destinataire;
}
public void setDestinataire(String destinataire) {
	this.destinataire = destinataire;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getLieu() {
	return lieu;
}
public void setLieu(String lieu) {
	this.lieu = lieu;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDegre_urgence() {
	return degre_urgence;
}
public void setDegre_urgence(String degre_urgence) {
	this.degre_urgence = degre_urgence;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Demande(long id, String destinataire, Date date, String lieu, String description, String degre_urgence,
		String etat) {
	super();
	this.Id = id;
	this.destinataire = destinataire;
	this.date = date;
	this.lieu = lieu;
	this.description = description;
	this.degre_urgence = degre_urgence;
	this.etat = etat;
}

public Demande() {
	
}

}
