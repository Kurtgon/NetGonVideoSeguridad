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

import com.jacaranda.entity.Category;

import com.jacaranda.services.CrudService;

@RestController
@RequestMapping(path="/api")

public class CategoryController {
	
	// Creamos el servicio
	@Autowired
	private CrudService crudService;
	
	// Método Get
	@GetMapping("categorys")
	public ResponseEntity<?>getCategory(){
		return crudService.getCategory();
	}
	
	// Método Get por parámetro id
	@GetMapping("/categorys/{id}")
	public ResponseEntity<?> getCategoryId(@PathVariable long id){
		return crudService.getCategoryId(id);
	}
	
	//Método Post
	@PostMapping("categorys")
	public ResponseEntity<?> createCategory(@RequestBody Category sent ){
		return crudService.createCategory(sent);
	}
	
	//Método Put
	@PutMapping("categorys")
	public ResponseEntity<?> updateCategory(@RequestBody Category sent){
		return crudService.updateCategory(sent);
	}
		
	//Método Delete
	@DeleteMapping("categorys/{id}")
	public ResponseEntity<?>deleteCategory(@PathVariable long id){
		return crudService.deleteCategory(id);
	}
}