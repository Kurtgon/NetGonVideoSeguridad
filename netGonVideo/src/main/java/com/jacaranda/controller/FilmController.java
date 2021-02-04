package com.jacaranda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.entity.Film;
import com.jacaranda.services.CrudService;


@RestController
@RequestMapping(path="/api")

public class FilmController {
	
	//Creamos el servicio
	@Autowired
	private CrudService crudService;
	
	// Método GET
	@GetMapping("/films")
	public ResponseEntity<?>getCustomer(){
		return crudService.getFilm();
	}
		
	// Método Get por parámetro id
	@GetMapping("/films/{id}")
	public ResponseEntity<?> getCustomerId(@PathVariable int id){
		return crudService.getFilmId(id);
	}
		
	// Método POST
	@PostMapping("/films")
	public ResponseEntity<?>createFilm(@RequestBody Film sent){
		return crudService.createFilm(sent);
	}
		
	// Método PUT
	@PutMapping("/films")
	public ResponseEntity<?>updateFilm(@RequestBody Film sent){
		return crudService.updateFilm(sent);
	}

	// Método DELETE
	@DeleteMapping("/films/{id}")
	public ResponseEntity<?>deleteFilm(@PathVariable long id){
		return crudService.deleteFilm(id);
	}
}
