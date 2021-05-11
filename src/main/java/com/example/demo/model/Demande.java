package com.example.demo.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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


@ManyToOne
@JoinColumn(name="employee_id")
private Employee employee_id;

public Demande() {
	
}

public Demande(long id, String destinataire, Date date, String lieu, String description, String degre_urgence,
		String etat, Employee employee_id) {
	super();
	this.id = id;
	this.destinataire = destinataire;
	this.date_D = date;
	this.lieu = lieu;
	this.description = description;
	this.degre_urgence = degre_urgence;
	this.etat = etat;
	this.employee_id = employee_id;
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

public void setDate_D(Date date) {
	this.date_D = date;
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

public Employee getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(Employee employee_id) {
	this.employee_id = employee_id;
}



}
