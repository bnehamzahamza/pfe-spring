package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="besoins")
public class Besoins {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(targetEntity  = Fourniture.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "besoinsF_id",referencedColumnName = "id")
	private List<Fourniture> besoinsF_id;
	
	@OneToMany(targetEntity = Materiel.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="besoinsM_id",referencedColumnName ="id")
	private List<Materiel> besoinsM_id;
	
	@OneToMany(targetEntity = Personnel.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="besoinsP_id",referencedColumnName ="id")
	private List<Personnel> besoinsP_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "demande_id", referencedColumnName = "id")
	private Demande demande_id;
	
	@Column(name = "date_F")
	@Temporal(TemporalType.DATE)
	private Date date_F;
	

	public Besoins() {
		
	}
	
	public Besoins(long id, List<Fourniture> besoinsF_id, List<Materiel> besoinsM_id, List<Personnel> besoinsP_id,
			Demande demande_id, Date date_F) {
		super();
		this.id = id;
		this.besoinsF_id = besoinsF_id;
		this.besoinsM_id = besoinsM_id;
		this.besoinsP_id = besoinsP_id;
		this.demande_id = demande_id;
		this.date_F = date_F;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Fourniture> getBesoinsF_id() {
		return besoinsF_id;
	}

	public void setBesoinsF_id(List<Fourniture> besoinsF_id) {
		this.besoinsF_id = besoinsF_id;
	}

	public List<Materiel> getBesoinsM_id() {
		return besoinsM_id;
	}

	public void setBesoinsM_id(List<Materiel> besoinsM_id) {
		this.besoinsM_id = besoinsM_id;
	}

	public List<Personnel> getBesoinsP_id() {
		return besoinsP_id;
	}

	public void setBesoinsP_id(List<Personnel> besoinsP_id) {
		this.besoinsP_id = besoinsP_id;
	}

	public Demande getDemande_id() {
		return demande_id;
	}

	public void setDemande_id(Demande demande_id) {
		this.demande_id = demande_id;
	}

	public Date getDate_F() {
		return date_F;
	}

	public void setDate_F(Date date_F) {
		this.date_F = date_F;
	}


	
	
	
	
	
}
