package com.jacaranda.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jacaranda.entity.Category;
import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Film;
import com.jacaranda.entity.Serie;
import com.jacaranda.entity.tipoCategory;
import com.jacaranda.repo.CategoryRepository;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.FilmRepository;

import com.jacaranda.repo.SerieRepository;

import javassist.NotFoundException;

@Service
public class CrudService {
	
	// Añadiendo los repositorios
	@Autowired
	private CrudRepository<Customer, Long> crudRepositoryCustomer;
	
//	@Autowired
//	private CrudRepository<Product, Long> crudRepositoryProduct;
	
	@Autowired
	private CrudRepository<Category, Long> crudRepositoryCategory;
	
	@Autowired
	private CrudRepository<Film, Long> crudRepositoryFilm;
	
	@Autowired
	private CrudRepository<Serie, Long> crudRepositorySerie;
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	//Añadiendo Servicios
	@Autowired
	private UpdateService updateService;
	
	// ENTIDAD CUSTOMER
	
	// Método Get Customer
	public ResponseEntity<?>getCustomer(){
		Iterable<Customer> resultado = crudRepositoryCustomer.findAll(); 
		ResponseEntity<?> response;
		if(((Collection<?>)resultado).size() == 0) {
			response= ResponseEntity
					 .status(HttpStatus.NOT_FOUND)
					 .body("La base de datos está vacía");
		}else {
			 response= ResponseEntity
					 .status(HttpStatus.OK)
					 .body(crudRepositoryCustomer.findAll());
		}
		return response;
	}
	
	// Método Get con parámetro id
	public ResponseEntity<?> getCustomerId(@PathVariable long id){
		Customer customer = customerRepository.findCustomerById(id);
		ResponseEntity<?> response;
		if(customer==null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("El cliente no existe");
		}else {
			response = ResponseEntity
					.status(HttpStatus.OK)
					.body(crudRepositoryCustomer.findById(id));
		}
		return response;
	}
	
	//Probar el método Get con id para el test
//	public Customer getCustomerId(long id) throws NotFoundException {
//		Customer customer = customerRepository.findCustomerById(id);
//		if(customer == null) {
//			throw new NotFoundException("No existe el cliente");
//		}
//		return customer;
//	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	// Método Post
	public ResponseEntity<?> createCustomer(@RequestBody Customer sent) {
		String dni = sent.getDni();
		Customer c = customerRepository.findCustomerByDni(dni);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity
					.status(HttpStatus.CREATED)
					.body(crudRepositoryCustomer.save(sent));
		} else {
			response = ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Ya existe el customer");
		}
		return response;
	}
	
	// Método Put
	public ResponseEntity<?> updateCustomer(@RequestBody Customer sent) {
		String dni = sent.getDni();
		Customer c = customerRepository.findCustomerByDni(dni);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe el customer");
		} else {
			updateService.upCustomer(c, sent);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(crudRepositoryCustomer.save(c));
		}
		return response;
	}
	
	// Método Delete
	public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
		Customer c = customerRepository.findCustomerById(id);
		ResponseEntity<?> response;
		if (c == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe el customer");
		} else {
			crudRepositoryCustomer.deleteById(id);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Se ha eliminado el customer");
		}
		return response;
	}
	
/*	// ENTIDAD PRODUCT
	
	// Método Get
	public ResponseEntity<?>getProduct(){
		Iterable<Product> resultado= crudRepositoryProduct.findAll();
		ResponseEntity<?> response;
		if(((Collection<?>)resultado).size() == 0) {
			response = ResponseEntity
					 .status(HttpStatus.NOT_FOUND)
					 .body("No hay productos. La lista está vacía");
			
		}else {
			response= ResponseEntity
					 .status(HttpStatus.OK)
					 .body(crudRepositoryProduct.findAll());
		}
		return response;
	}
	
	// Método Get con parámetro id
	public ResponseEntity<?> getProductId(@PathVariable long id){
		Product p = productRepository.findProductById(id);
		ResponseEntity<?> response;
		if(p == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("El producto no existe");
		}else {
			response = ResponseEntity
					.status(HttpStatus.OK)
					.body(crudRepositoryProduct.findById(id));
		}
		return response;
	}
	
	// Método Post
	public ResponseEntity<?> createProduct(@RequestBody Product sent ){
		String title = sent.getTitle();
		Product p = productRepository.findProductByTitle(title);
		ResponseEntity<?> response;
		if(p == null) {
			response = ResponseEntity
					.status(HttpStatus.CREATED)
					.body(crudRepositoryProduct.save(sent));
		}else {
			response = ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Ya existe el producto");
		}
		return response;
	}
	
	// Método Put
	public ResponseEntity<?> updateProduct(@RequestBody Product sent){
		String title = sent.getTitle();
		Product p = productRepository.findProductByTitle(title);
		ResponseEntity<?> response;
		if(p == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe el producto");
		}else {
			updateService.upProduct(p, sent);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(crudRepositoryProduct.save(p));
		}
		return response;
	}

	// Método Delete
	public ResponseEntity<?>deleteProduct(@PathVariable long id){
		Product p = productRepository.findProductById(id);
		ResponseEntity<?>response;
		if(p == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe el producto");
		}else {
			crudRepositoryProduct.deleteById(id);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Se ha eliminado el producto");
		}
		return response;
	}*/

	// ENTIDAD CATEGORY
	
	// Método Get
	public ResponseEntity<?>getCategory(){
		Iterable<Category> resultado = crudRepositoryCategory.findAll();
		ResponseEntity<?> response;
		if(((Collection<?>)resultado).size() == 0) {
			response = ResponseEntity
					 .status(HttpStatus.NOT_FOUND)
					 .body("No hay categorías. La lista está vacía.");
		}else {
			response = ResponseEntity
					 .status(HttpStatus.OK)
					 .body(crudRepositoryCategory.findAll());
		}
		return response;
	}
	
	// Método Get con parámetro id
	public ResponseEntity<?> getCategoryId(@PathVariable long id){
		Category c = categoryRepository.findCategoryById(id);
		ResponseEntity<?> response;
		if(c == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("La categoría no existe");
		}else {
			response = ResponseEntity
					.status(HttpStatus.OK)
					.body(crudRepositoryCategory.findById(id));
		}
		return response;
	}

	// Método Post
	public ResponseEntity<?> createCategory(@RequestBody Category sent ){
		tipoCategory tipoCategory = sent.getTipoCategory();
		Category c = categoryRepository.findCategoryByTipoCategory(tipoCategory);
		ResponseEntity<?> response;
		if(c == null) {
			response = ResponseEntity
					.status(HttpStatus.CREATED)
					.body(crudRepositoryCategory.save(sent));
		}else {
			response = ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Ya existe la categoría");
		}
		return response;
		}
	
	// Método Put
	public ResponseEntity<?> updateCategory(@RequestBody Category sent){
		long id = sent.getId();
		Category c = categoryRepository.findCategoryById(id);
		ResponseEntity<?> response;
		if(c == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la categoría");
		}else {
			updateService.upCategory(c, sent);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(crudRepositoryCategory.save(c));
		}
		return response;
	}
	
	// Método Delete
	public ResponseEntity<?>deleteCategory(@PathVariable long id){
		Category c = categoryRepository.findCategoryById(id);
		ResponseEntity<?>response;
		if(c == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la categoría");
		}else {
			crudRepositoryCategory.deleteById(id);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Se ha eliminado la categoría");
		}
		return response;
	}
	
	// ENTIDAD FILM
	
	// Método Get
	public ResponseEntity<?>getFilm(){
		Iterable<Film> resultado = crudRepositoryFilm.findAll();
		ResponseEntity<?> response;
		 if(((Collection<?>)resultado).size() == 0) {
			 response= ResponseEntity
					 .status(HttpStatus.NOT_FOUND)
					 .body("No hay peliculas. La lista está vacía");
			 
		 }else{
			 response= ResponseEntity
					 .status(HttpStatus.OK)
					 .body(crudRepositoryFilm.findAll());
		 }
		 return response;
	}
	
	// Método Get por parámetro id
	public ResponseEntity<?> getFilmId(@PathVariable long id){
		Film f = filmRepository.findFilmById(id);
		ResponseEntity<?> response;
		if(f == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("La pelicula no existe");
		}else {
			response = ResponseEntity
					.status(HttpStatus.OK)
					.body(crudRepositoryFilm.findById(id));
		}
		return response;
	}
	
	// Método Post
	public ResponseEntity<?>createFilm(@RequestBody Film sent){
		String title = sent.getTitle();
		Film f = filmRepository.findFilmByTitle(title);
		ResponseEntity<?> response;
		if(f ==null) {
			long idCategory = sent.getCategorias().getId();
			Category categorySent = categoryRepository.findCategoryById(idCategory);
			if(categorySent == null) {
				response = ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("La categoría no existe");
			}else {
				sent.setCategorias(categorySent);
				response = ResponseEntity
						.status(HttpStatus.CREATED)
						.body(crudRepositoryFilm.save(sent));
			}	
		}else {
			response=ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Ya existe la pelicula");
		}
		return response;
	}
	
	// Método PUT
	public ResponseEntity<?>updateFilm(@RequestBody Film sent){
		String title = sent.getTitle();
		Film f = filmRepository.findFilmByTitle(title);
		ResponseEntity<?> response;
		if(f == null) {
			response =ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la pelicula");
		}else {
			updateService.upFilm(f, sent);
			response =ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(crudRepositoryFilm.save(f));
		}
		return response;
	}

	//Método DELETE
	public ResponseEntity<?>deleteFilm(@PathVariable long id){
		Film f = filmRepository.findFilmById(id);
		ResponseEntity<?>response;
		if(f == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la pelicula");
		}else {
			crudRepositoryFilm.deleteById(id);
			response = ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Se ha eliminado la pelicula");
		}
		return response;
	}
	
	// ENTIDAD SERIE
	
	// Método Get
	public ResponseEntity<?>getSerie(){
		Iterable<Serie> resultado = crudRepositorySerie.findAll();
		ResponseEntity<?> response;
		if(((Collection<?>)resultado).size() == 0) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No hay series. La lista está vacía");	
		}else{
		 response = ResponseEntity
				 .status(HttpStatus.OK)
				 .body(crudRepositorySerie.findAll());
		}
		return response;
	}
	
	// Método Get por parámetro id
	public ResponseEntity<?> getSerieId(@PathVariable long id){
		Serie s = serieRepository.findFilmById(id);
		ResponseEntity<?> response;
		if(s == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("La serie no existe");
		}else {
			response = ResponseEntity
					.status(HttpStatus.OK)
					.body(crudRepositorySerie.findById(id));
		}
		return response;
	}
	
	// Método POST
	public ResponseEntity<?>createSerie(@RequestBody Serie sent){
		String title = sent.getTitle();
		Serie s = serieRepository.findFilmByTitle(title);
		ResponseEntity<?> response;
		if(s == null) {
			long idCategory = sent.getCategorias().getId();
			Category categorySent = categoryRepository.findCategoryById(idCategory);
			if(categorySent == null) {
				response =ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("La categoría no existe");
			}else {
				sent.setCategorias(categorySent);
				response=ResponseEntity
						.status(HttpStatus.CREATED)
						.body(crudRepositorySerie.save(sent));
			}
		}else {
			response=ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Ya existe la serie");
		}
		return response;
	}
	
	// Método PUT
	public ResponseEntity<?>updateSerie(@RequestBody Serie sent){
		String title = sent.getTitle();
		Serie s = serieRepository.findFilmByTitle(title);
		ResponseEntity<?> response;
		if(s == null) {
			response =ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la serie");
		}else {
			updateService.upSerie(s, sent);
			response =ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(crudRepositorySerie.save(s));
		}
		return response;
	}
	
	// Método DELETE
	public ResponseEntity<?>deleteSerie(@PathVariable long id){
		Serie s = serieRepository.findFilmById(id);
		ResponseEntity<?>response;
		if(s == null) {
			response = ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("No existe la serie");
	}else {
		crudRepositorySerie.deleteById(id);
		response = ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body("Se ha eliminado la serie");
		}
		return response;
	}
	
}
