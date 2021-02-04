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


import com.jacaranda.entity.Serie;
import com.jacaranda.services.CrudService;


@RestController
@RequestMapping(path="/api")

public class SerieController {
	
	// Creamos el servicio
	@Autowired
	private CrudService crudService;
	
	// Método Get
	@GetMapping("/series")
	public ResponseEntity<?>getSerie(){
		return crudService.getSerie();
		}
	
	// Método Get por parámetro id
	@GetMapping("/series/{id}")
	public ResponseEntity<?> getSerieId(@PathVariable long id){
		return crudService.getCategoryId(id);
	}
	
	// Método POST
	@PostMapping("/series")
	public ResponseEntity<?>createSerie(@RequestBody Serie sent){
		return crudService.createSerie(sent);
	}
	
	// Método PUT
	@PutMapping("/series")
	public ResponseEntity<?>updateSerie(@RequestBody Serie sent){
		return crudService.updateSerie(sent);
	}
	
	// Método DELETE
	@DeleteMapping("/series/{id}")
	public ResponseEntity<?>deleteSerie(@PathVariable int id){
		return crudService.deleteSerie(id);
	}

}
