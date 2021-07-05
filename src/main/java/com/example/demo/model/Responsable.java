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
@Table(name = "Responsable")
public class Responsable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="departement")
	private String departement;
	@Column(name = "login")
	private String login;
	@Column(name = "mdp")
	private String mdp;
	
	@OneToMany(targetEntity  = Demande.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "res_id",referencedColumnName = "id")
	private List<Demande> res_id;

	public Responsable() {
		
	}
	public Responsable(long id, String departement, String login, String mdp, List<Demande> res_id) {
		super();
		this.id = id;
		this.departement = departement;
		this.login = login;
		this.mdp = mdp;
		this.res_id = res_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
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

	public List<Demande> getRes_id() {
		return res_id;
	}

	public void setRes_id(List<Demande> res_id) {
		this.res_id = res_id;
	}
	
	
	
}
