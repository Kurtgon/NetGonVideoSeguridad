package com.jacaranda.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.DocumentRepository;

@Service
public class TransferFileService extends AbstractServiceUtils {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private FileHandlerService fileHandlerService;

	//Fichero que vamos a subir
	public ResponseEntity<?> addFile(MultipartFile mpf, long id) {
		Customer c = customerRepository.findCustomerById(id);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con ese id no existe");
		} else {
			if (Integer.valueOf((int) mpf.getSize()) > 1048576) {
				response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Error, ha superado el límite del fichero para la subida");
			} else {
				Document doc = new Document(fileHandlerService.createBlob(mpf), mpf.getName(), mpf.getContentType(),
						Integer.valueOf((int) mpf.getSize()));
				documentRepository.save(doc);
				c.setDoc(doc);
				response = ResponseEntity.
						status(HttpStatus.CREATED)
						.body(customerRepository.save(c));
			}
		}
		return response;
	}

	// Fichero que vamos a bajar
	public ResponseEntity<?> downLoadFile(long id) throws SQLException {
		Customer c = customerRepository.findCustomerById(id);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con ese id no existe");
		} else {
			Document doc = c.getDoc();
			if (doc == null) {
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El fichero no existe");
			} else {
				response = ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getFileType()))
						.header("Descargando el fichero", "attachment; filename=\"" + doc.getFileName() + "\"")
						.body(new ByteArrayResource(doc.getFichero().getBytes(1L, (int) doc.getFichero().length())));
			}

		}
		return response;
	}

}
