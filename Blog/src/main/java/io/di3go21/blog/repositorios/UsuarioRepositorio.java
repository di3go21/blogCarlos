package io.di3go21.blog.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.di3go21.blog.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByNickname(String nickname);
	
	public Optional<Usuario> findByEmail(String email);
	

}
