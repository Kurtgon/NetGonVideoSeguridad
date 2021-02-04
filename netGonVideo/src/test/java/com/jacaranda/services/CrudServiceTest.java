package com.jacaranda.services;

import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.Assert;

import com.jacaranda.entity.Customer;
import com.jacaranda.repo.CustomerRepository;

import javassist.NotFoundException;

public class CrudServiceTest {

	
//	@InjectMocks
//	CrudService crudService = new CrudService();
//	
//	@Mock
//	private CustomerRepository customerRepository;
	
	
	//Clase que va estar sujeto de prueba
	//private CrudService sut;
	
	
	//Creamos las dependecias 
//	private Customer mockedCustomer;
//	private CustomerRepository mockedCRepo;
	
	
//	@BeforeEach
//	private void init() {
//		sut = new CrudService();
//		mockedCustomer = mock(Customer.class);
//		mockedCRepo = mock(CustomerRepository.class);
//		//Seteo de las dependencias
//		sut.setCustomerRepository(mockedCRepo);
//		
//		
//	}
	
//	@Test
//	public void getCustomerIdTest() {
		
//		try {
//			Mockito.when(mockedCRepo.findCustomerById(Mockito.anyLong())).thenReturn(mockedCustomer);
//			//Llamamos al método
//			assert(mockedCustomer == sut.getCustomerId(1));
//			
//		}catch (Exception e) {
//			throw new AssertionError(e.getMessage());
//		}
//	}
//	
//	@Test
//	public void getCustomerIdThrowsNotFoundExceptionTest() {
//		
//		try {
//			Mockito.when(mockedCRepo.findCustomerById(Mockito.anyLong())).thenReturn(null);
//			//Llamamos al método
//			sut.getCustomerId(1);
//			
//		}catch(NotFoundException nfe) {
//			Assert.isInstanceOf(NotFoundException.class, nfe);
//		}catch(Exception e) {
//			throw new AssertionError(e.getMessage());
//		}
//		
//	}
}
