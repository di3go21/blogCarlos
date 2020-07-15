package io.di3go21.blog.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.di3go21.blog.model.Tag;

@Repository
public interface TagRepositorio extends JpaRepository<Tag,Long> {
	
	
	public Optional<Tag> findByNombre (String nombre);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
