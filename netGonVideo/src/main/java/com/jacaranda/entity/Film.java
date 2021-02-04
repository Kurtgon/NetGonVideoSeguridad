package com.jacaranda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Film extends Product implements Serializable {

	//Variables
	private String duration;
	private String pegy;
	
	// Relación con la entidad Categoría
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categorias_id", foreignKey = @ForeignKey(name="categorias_id_fk"), nullable = false)
	@Enumerated
	private Category categorias;
	
	// Relación con visualizaciones
	@OneToMany(mappedBy="film")
	private List<Visual> visualizaciones;
	
	//Constructores
	public Film() {
		super();
	
	}

	public Film(String title, String description, int agno, Category categorias, String duration, String pegy) {
		super(title, description, agno);
		this.duration=duration;
		this.pegy=pegy;
		this.categorias=categorias;
	}


	//GET Y SET
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPegy() {
		return pegy;
	}

	public void setPegy(String pegy) {
		this.pegy = pegy;
	}

	public Category getCategorias() {
		return categorias;
	}

	public void setCategorias(Category categorias) {
		this.categorias = categorias;
	}
	
}
