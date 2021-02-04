package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Serie;


@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {
	
	@Query(value="select * from Serie order by title", nativeQuery = true)
	public List<Serie> findAllOrdenedByTitle();
	
	public Serie findFilmByTitle(String title);
	
	public Serie findFilmById(Long id);

}
