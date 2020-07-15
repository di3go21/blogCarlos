package io.di3go21.blog.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.di3go21.blog.model.Comentario;
import io.di3go21.blog.model.ComentarioRespuesta;
import io.di3go21.blog.model.Usuario;
import io.di3go21.blog.repositorios.UsuarioRepositorio;
import io.di3go21.blog.servicios.ComentariosServicio;

@Controller
public class ComentarioController { 
	
	

	@Autowired
	private ComentariosServicio comentarioServicio;
	
	@Autowired UsuarioRepositorio usuRepo;
	
	@PostMapping("/respuesta/{id}")
	public String respuestaDeComentario(@PathVariable long id,@ModelAttribute ComentarioRespuesta resp) {
		
		String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		System.err.println("lo que recupera es " +nombreUsuario);
		
		
		Usuario	usu = usuRepo.findByNickname(nombreUsuario).get();
		
		System.err.println("VAMOS A BUSCAR EL COMENTARIO DE ID "+id);
		Comentario com = this.comentarioServicio.buscaPorId(id).get();
		System.err.println(com);
		
		System.err.println("EL COMENTARIO ANIDADO ES");
		
		System.err.println(resp);
		
		
		String redirect = "redirect:/post/"+comentarioServicio.buscaPorId(id).get().getPost().getId();
		
		System.err.println(redirect);
		
		
//		com = this.comentarioServicio.buscaPorId(id).get();
		
		
		resp.setUsuario(usu);
		resp=this.comentarioServicio.guardaAnidado(resp);

		com.getReplys().add(resp);
		
		this.comentarioServicio.guardaComentario(com);
		
		
		return redirect;
		
	}
	
	@PostMapping("/respuesta2/{id_com}/{id_post}")
	public String respuestaDeRespuesta(@PathVariable long id_com,@PathVariable long id_post,@ModelAttribute ComentarioRespuesta comentario_respuestax2) {
		
		String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		
		
		Usuario	usu = usuRepo.findByNickname(nombreUsuario).get();
		
	
		
		String redirect = "redirect:/post/"+id_post;
		
		comentario_respuestax2.setUsuario(usu);

		comentario_respuestax2=this.comentarioServicio.guardaAnidado(comentario_respuestax2);
		
		ComentarioRespuesta comentario_a_responder = this.comentarioServicio.buscaComentarioRespPorId(id_com);
		
		
		comentario_a_responder.getReplys().add(comentario_respuestax2);
		
		comentario_a_responder= this.comentarioServicio.guardaAnidado(comentario_a_responder);
		
		return redirect;
	}
	
	
	
	
	
//	
//	public String 
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	private us
//	
}
