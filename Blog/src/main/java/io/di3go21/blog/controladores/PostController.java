package io.di3go21.blog.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.di3go21.blog.model.Comentario;
import io.di3go21.blog.model.Post;
import io.di3go21.blog.servicios.ComentariosServicio;
import io.di3go21.blog.servicios.PostServicio;

@Controller
public class PostController {

	@Autowired
	private PostServicio postServicio;
	
	@Autowired
	private ComentariosServicio comentarioServicio;
	
	
	@GetMapping("/post/{id}/**")
	public String postIndividual(@PathVariable long id, Model model ) {
		
		Post post= postServicio.buscaPorId(id).get();
		List<Comentario> coments = comentarioServicio.dameComentariosDeUnPost(id);
		model.addAttribute("post",post);
		model.addAttribute("comentarios",coments);
		
		
		
		
		return "postind";
	}
	
}
