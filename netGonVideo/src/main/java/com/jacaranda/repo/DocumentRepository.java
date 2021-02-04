package com.jacaranda.repo;

import org.springframework.data.repository.CrudRepository;

import com.jacaranda.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {
	
	
}
