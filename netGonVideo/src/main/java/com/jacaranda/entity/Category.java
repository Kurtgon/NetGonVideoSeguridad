package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private tipoCategory tipoCategory;
	
	
	public Category() {
		super();
	}
	
	//Constructores
	public Category(tipoCategory tipoCategory) {
		super();
		this.tipoCategory = tipoCategory;
	}

	
	//GET y SET
	public tipoCategory getTipoCategory() {
		return tipoCategory;
	}

	public void setTipoCategory(tipoCategory tipoCategory) {
		this.tipoCategory = tipoCategory;
	}

	public long getId() {
		return id;
	}
	
}
