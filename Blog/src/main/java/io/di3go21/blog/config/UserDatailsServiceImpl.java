package io.di3go21.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import io.di3go21.blog.model.Usuario;
import io.di3go21.blog.servicios.UsuarioServicio;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioServicio usuarioServ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioServ.buscaPorNick(username);
		if (usuario == null)
			usuario = usuarioServ.buscaPorEmail(username);

		UserBuilder builder = null;

		if (usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
			
			return builder.build();

		}

		else {
			System.err.println("el usuario no existe");

			throw new UsernameNotFoundException("Usuario no existente en la BBDD");
		}

	}

}
