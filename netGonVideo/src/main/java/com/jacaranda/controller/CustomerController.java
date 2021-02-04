package com.jacaranda.controller;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.services.CrudService;
import com.jacaranda.services.TransferFileService;

@RestController
@RequestMapping(path = "/api")

public class CustomerController {

	// Creamos el servicio
	@Autowired
	private CrudService crudService;
	
	@Autowired
	private TransferFileService transferFileService;

	// Método GET
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomer() {
		return crudService.getCustomer();
	}

	// Método Get por parámetro id
	@GetMapping("/customers/{id}")
	public ResponseEntity<?> getCustomerId(@PathVariable long id) {
		return crudService.getCustomerId(id);
	}

	// Método POST
	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer sent) {
		return crudService.createCustomer(sent);
	}

	// Método PUT
	@PutMapping("/customers")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer sent) {
		return crudService.updateCustomer(sent);
	}

	// Método DELETE
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
		return crudService.deleteCustomer(id);
	}
	
	//Subir fichero
	@PutMapping("/customers/{id}/doc")
	public ResponseEntity<?>addFile(@RequestParam MultipartFile mpf, @PathVariable long id){
		return transferFileService.addFile(mpf, id);
	}
	
	//Bajar fichero
	@GetMapping("/customers/{id}/doc")
	public ResponseEntity<?>downLoadFile(@PathVariable long id) throws SQLException{
		return transferFileService.downLoadFile(id);
	}

}
