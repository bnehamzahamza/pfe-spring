package com.example.demo.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Demande")
public class Demande {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column(name = "destinataire")
private String destinataire;
@Column(name = "date_D")
@Temporal(TemporalType.DATE)
private Date date_D;
@Column(name = "lieu")
private String lieu;
@Column(name = "decription")
private String description;
@Column(name = "degre_urgence")
private String degre_urgence;
@Column(name = "etat")
private String etat;
@Type(type = "org.hibernate.type.NumericBooleanType")
@Column(name = "accord_responsable")
private boolean accord_responsable;
@Type(type = "org.hibernate.type.NumericBooleanType")
@Column(name = "accord_dmg")
private boolean accord_dmg;
@Column(name = "frais")
private Number frais;


@OneToOne(mappedBy = "demande_id")
private Besoins besoins;


public Demande() {
	
}

public Demande(long id, String destinataire, Date date_D, String lieu, String description, String degre_urgence,
		String etat, boolean accord_responsable, boolean accord_dmg, Number frais) {
	super();
	this.id = id;
	this.destinataire = destinataire;
	this.date_D = date_D;
	this.lieu = lieu;
	this.description = description;
	this.degre_urgence = degre_urgence;
	this.etat = etat;
	this.accord_responsable = accord_responsable;
	this.accord_dmg = accord_dmg;
	this.frais = frais;



}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getDestinataire() {
	return destinataire;
}

public void setDestinataire(String destinataire) {
	this.destinataire = destinataire;
}

public Date getDate_D() {
	return date_D;
}

public void setDate_D(Date date_D) {
	this.date_D = date_D;
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



public void setAccord_responsable(boolean accord_responsable) {
	this.accord_responsable = accord_responsable;
}



public void setAccord_dmg(boolean accord_dmg) {
	this.accord_dmg = accord_dmg;
}


public boolean isAccord_responsable() {
	return accord_responsable;
}

public boolean isAccord_dmg() {
	return accord_dmg;
}

public Number getFrais() {
	return frais;
}

public void setFrais(Number frais) {
	this.frais = frais;
}








}