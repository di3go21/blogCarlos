package io.di3go21.blog;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.di3go21.blog.model.Comentario;
import io.di3go21.blog.model.Post;
import io.di3go21.blog.model.Tag;
import io.di3go21.blog.model.Usuario;
import io.di3go21.blog.repositorios.ComentarioRepositorio;
import io.di3go21.blog.repositorios.PostRepositorio;
import io.di3go21.blog.repositorios.TagRepositorio;
import io.di3go21.blog.repositorios.UsuarioRepositorio;
import io.di3go21.blog.servicios.UsuarioServicio;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner initData( @Autowired UsuarioRepositorio usuR,@Autowired PostRepositorio postR,@Autowired ComentarioRepositorio comR,@Autowired TagRepositorio tagR,@Autowired UsuarioServicio usuS) {
		return (args)->{
	
			Usuario usu = Usuario.builder().email("test@test")
					.avatar("miabatar.jpg")
					.fechaAlta(Date.from(Instant.now()))
					.nickname("di3go2")
					.password("123456")
					.build();
			Usuario usu2 = Usuario.builder().email("test2@test")
					.avatar("miavatar.jpg")
					.fechaAlta(Date.from(Instant.now()))
					.nickname("di3go22")
					.password("123456")
					.build();
			
//			usu=usuR.save(usu);
//			usu=usuR.save(usu);
//			usu2=usuR.save(usu2);
			usu= usuS.registrar(usu); 

			usu2= usuS.registrar(usu2); 
			
			
			Tag tag = new Tag();
			tag.setNombre("Comida");
			tag=tagR.save(tag);
			
			Tag tag2 = new Tag();
			tag2.setNombre("Bebida");
			tag2=tagR.save(tag2);
			

			Tag tag3 = new Tag();
			tag3.setNombre("Turismo");
			tag3=tagR.save(tag3);
			
			
			
			//escribe un post
			
			Post post= new Post();
			for (int i = 0; i < 2; i++) {
				post = new Post();
				post.setAutor(usu);
				post.setContenido("este es mi primer post "+i);
				post.setTitulo("TITULO DEL POST+i");
				post.setUrl("localhost:8001/post/1");
				post.setTags(Arrays.asList(tag,tag3));
				
				post=postR.save(post);
			}
			
			
			//comentarios
			
			Comentario comment = new Comentario();
			comment.setPost(post);
			comment.setUsuario(usu2);
			comment.setContenido("HOLA TIO BUEN POST");
			comR.save(comment);
			
			Comentario comment2 = new Comentario();
			comment2.setPost(post);
			comment2.setUsuario(usu);
			comment2.setContenido("MUCHAS GRACIAS BROO");
			comR.save(comment2);
			
			
			Comentario comment3 = new Comentario();
			comment3.setPost(post);
			comment3.setUsuario(usu2);
			comment3.setContenido("DE NADA SIGUE VISITANDO MI PAGINA");
			comR.save(comment3);
			
			List<Post> postsDeComida;
			Tag tag_prueba= new Tag();
			tag_prueba.setNombre("Comida");
			System.err.println(tagR.findByNombre("Comida").get());
			postsDeComida= postR.findByTags(tagR.findByNombre("Comida").get());
			System.err.println(postsDeComida);
			
			postsDeComida= postR.findByTagsNombre("Turismo");
			postsDeComida.forEach(System.out::println);
			
			
			Usuario usuariopollo = new Usuario();
			Post postnuevo = new Post();
			postnuevo.setId(6);
			usuariopollo.setId(1L);
			Comentario com = new Comentario();
			com.setUsuario(usuariopollo);
			com.setContenido("aslasdj");
			com.setPost(postnuevo);
			comR.save(com);
			
			
			
			
			
			
};
}
	
	

}
