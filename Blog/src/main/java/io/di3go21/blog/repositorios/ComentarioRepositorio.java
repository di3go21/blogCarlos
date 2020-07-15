package io.di3go21.blog.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.di3go21.blog.model.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{

	public List<Comentario> findByPostId(long id);
	
	public List<Comentario> findByUsuarioId(long id);
	
	
}
