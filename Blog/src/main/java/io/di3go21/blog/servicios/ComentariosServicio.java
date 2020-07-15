package io.di3go21.blog.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.di3go21.blog.model.Comentario;
import io.di3go21.blog.model.ComentarioRespuesta;
import io.di3go21.blog.repositorios.ComentarioRepositorio;
import io.di3go21.blog.repositorios.ComentarioRespuestaRepositorio;

@Service
public class ComentariosServicio {

	@Autowired
	private ComentarioRepositorio comentarioRepositorio;
	@Autowired
	private ComentarioRespuestaRepositorio comentarioRespuestaRepositorio;
	
	public List<Comentario> dameComentariosDeUnPost(long idPost){
		
		return this.comentarioRepositorio.findByPostId(idPost);
		
	}
	
	public ComentarioRespuesta guardaAnidado(ComentarioRespuesta comeResp) {
		
		
		return this.comentarioRespuestaRepositorio.save(comeResp);
	}
	
	public Optional<Comentario> buscaPorId(long id){
		return this.comentarioRepositorio.findById(id);
	}
	
	public Comentario guardaComentario(Comentario com) {
		return this.comentarioRepositorio.save(com);
	}
	
	public ComentarioRespuesta buscaComentarioRespPorId(long id) {
		return this.comentarioRespuestaRepositorio.findById(id).get();
	}
	
	
}
