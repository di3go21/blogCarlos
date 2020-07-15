package io.di3go21.blog.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.di3go21.blog.model.Post;
import io.di3go21.blog.servicios.PostServicio;

@Controller
public class PrincipalController {
	
	@Autowired
	PostServicio postServicio;
	
	
	@GetMapping({"/",""})
	public String principal(Model model) {
		
		List <Post> posts = postServicio.getPosts();
		posts.forEach(System.err::println);
		
		model.addAttribute("posts",posts);
		
		
		
		return "index";
	}
	
	@GetMapping("/vamos")
	public String vamos(Model model) {
		
		return "prueba";
	}
	
	
	

}
