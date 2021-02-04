package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Category;
import com.jacaranda.entity.tipoCategory;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	@Query(value="select * from Category order by tipoCategory", nativeQuery = true)
	public List<Category> findAllOrdeneByTipoCategory();
	
	public Category findCategoryByTipoCategory(tipoCategory tipoCategory);
	
	public Category findCategoryById(Long id);

}
