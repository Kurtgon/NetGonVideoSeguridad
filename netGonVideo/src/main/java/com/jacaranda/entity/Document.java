package com.jacaranda.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Blob fichero;
	private String fileName;
	private String fileType;
	private Integer fileSize;
	
	
	public Document() {
		super();
	}


	public Document(Blob fichero, String fileName, String fileType, Integer fileSize) {
		this.fichero = fichero;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Blob getFichero() {
		return fichero;
	}


	public void setFichero(Blob fichero) {
		this.fichero = fichero;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public Integer getFileSize() {
		return fileSize;
	}


	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	
	
	
	

}
