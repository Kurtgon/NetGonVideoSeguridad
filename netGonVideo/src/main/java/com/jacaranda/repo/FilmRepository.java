package com.jacaranda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Film;


@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
	
	@Query(value="select * from Film order by title", nativeQuery = true)
	public List<Film> findAllOrdenedByTitle();
	
	public Film findFilmByTitle(String title);
	
	public Film findFilmById(Long id);

}
