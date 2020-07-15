package io.di3go21.blog.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.di3go21.blog.model.Comentario;
import io.di3go21.blog.repositorios.ComentarioRepositorio;

@Service
public class ComentariosServicio {

	@Autowired
	private ComentarioRepositorio comentarioRepositorio;
	
	public List<Comentario> dameComentariosDeUnPost(long idPost){
		
		return this.comentarioRepositorio.findByPostId(idPost);
		
	}
	
	
}
