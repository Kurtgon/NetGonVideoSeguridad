package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@MappedSuperclass
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private int agno;
	
	//Debería ir la relación con categoría en vez de repetir en cada identidad hija pero con la etiqueta MappedSuperClass no identifica Product como entidad y da un error
	
	
	//Constructores
	public Product() {
		super();
		
	}
	
	public Product(String title, String description, int agno) {
		super();
		this.title = title;
		this.description = description;
		this.agno = agno;
		
	}
	
	//GET Y SET

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAgno() {
		return agno;
	}

	public void setAgno(int agno) {
		this.agno = agno;
	}

	public void setId(int id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
}
