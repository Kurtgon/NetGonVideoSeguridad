package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	@Query(value="select * from Customer order by name", nativeQuery = true)
	public List<Customer> findAllOrdenedByName();
	
	public Customer findCustomerByDni(String dni);
	
	public Customer findCustomerById(Long id);

}
