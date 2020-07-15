package io.di3go21.blog.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.di3go21.blog.model.Post;
import io.di3go21.blog.repositorios.PostRepositorio;

@Service
public class PostServicio {

	@Autowired
	private PostRepositorio postRepositorio;
	
	
	public  List <Post> getPosts(){
		return postRepositorio.findAll();
	}
	
	public Optional <Post> buscaPorId(long id){
		return this.postRepositorio.findById(id);
	}
}
