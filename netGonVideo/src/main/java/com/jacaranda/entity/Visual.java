package com.jacaranda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Visual implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Variables
	private long id;
	private Date inicioPlay;
	private Date finPlay;
	
	// Relación con la entidad Customer
	@ManyToOne
	@JoinColumn(name="customer_id", foreignKey = @ForeignKey(name="customer_id_fk"), nullable= false)
	private Customer customer;
	
	// Relación con la entidad Product
	@Transient
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id", foreignKey = @ForeignKey(name="product_id_fk"), nullable = false)
	private Product producto;
	
	// Relación con la entidad con Film
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="film_id", foreignKey = @ForeignKey(name="film_id_fk"), nullable = false)
	private Film film;
	
	// Relación con la entidad Serie
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="serie_id", foreignKey = @ForeignKey(name="serie_id_fk"), nullable = false)
	private Serie serie;
	
	//Constructores
	public Visual() {
		super();
	}
	
	public Visual(Date inicioPlay, Date finPlay, Customer customer, Product producto) {
		super();
		this.inicioPlay = inicioPlay;
		this.finPlay = finPlay;
		this.customer = customer;
		this.producto = producto;
	}


//GET Y SET
	public long getId() {
		return id;
	}

	public Date getInicioPlay() {
		return inicioPlay;
	}

	public Date getFinPlay() {
		return finPlay;
	}

	public Customer getCustomer() {
		return customer;
	}
	public Product getProducto() {
		return producto;
	}
	
}
