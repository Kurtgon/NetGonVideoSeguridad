package com.jacaranda.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Comparable<Customer>,Serializable {
	//Variables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String surnames;
	
	@NonNull
	@DateTimeFormat(pattern = "ddMMyyyy")
	private LocalDate birthDate;
	
	private String dni;
	
	// Relaciones con la entidad Visual
	@OneToMany(mappedBy="customer")
	private List<Visual> visualizaciones;
	
	//Relaciones con la entidad Document
	@OneToOne(targetEntity = Document.class)
	@JsonIgnore
	private Document doc;
	
	
	//Constructores
	public Customer() {
		super();
		visualizaciones = new ArrayList<Visual>();
	}


	public Customer(String name, String surnames, LocalDate birthDate, String dni, Document doc) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.birthDate = birthDate;
		this.dni = dni;
		this.doc = doc;
		visualizaciones = new ArrayList<Visual>();
	}

//GET y SET
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getDni() {
		return dni;
	}

	public List<Visual> getVisualizaciones() {
		return visualizaciones;
	}
	
	
	public Document getDoc() {
		return doc;
	}


	public void setDoc(Document doc) {
		this.doc = doc;
	}


	//ComparaTo
	@Override
	public int compareTo(Customer other) {
	
		return Long.valueOf(getId()).compareTo(getId());
	}
	
}
