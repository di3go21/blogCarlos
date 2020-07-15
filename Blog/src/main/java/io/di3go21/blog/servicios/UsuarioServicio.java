package io.di3go21.blog.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.di3go21.blog.model.Usuario;
import io.di3go21.blog.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepositorio usuarioRepo;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public Usuario buscaPorNick(String nick) {
		return usuarioRepo.findByNickname(nick).get();
	}
	
	public Usuario buscaPorEmail(String email) {
		return usuarioRepo.findByEmail(email).get();
	}
	
	public Usuario registrar (Usuario u) {
		System.out.println("vamos a registrarte");
		u.setPassword(passEncoder.encode(u.getPassword()));
		return usuarioRepo.save(u);
		
		
	}

}
