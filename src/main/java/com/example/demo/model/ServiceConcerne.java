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
@Table(name = "ServiceConcerne")
public class ServiceConcerne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="nom")
	private String nom;
	@Column(name ="login")
	private String login;
	@Column(name ="mdp")
	private String mdp;
	@OneToMany(targetEntity  = Demande.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "empsc_id",referencedColumnName = "id")
	private List<Demande> empsc_id;

	public ServiceConcerne() {
		
	}
	public ServiceConcerne(long id, String nom, List<Demande> empsc_id, String login, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.empsc_id = empsc_id;
		this.login = login;
		this.mdp = mdp;
		
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
	public List<Demande> getEmpsc_id() {
		return empsc_id;
	}
	public void setEmpsc_id(List<Demande> empsc_id) {
		this.empsc_id = empsc_id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	
}
