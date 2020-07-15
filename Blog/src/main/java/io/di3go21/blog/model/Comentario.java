package io.di3go21.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Comentario {

	@GeneratedValue
	@Id
	private long id;
	
	@ManyToOne
	private Usuario usuario;
	
	
	@ManyToOne
	private Post post;
	
	@Lob
	private String contenido;
	
	@CreationTimestamp
	private Date date;
	
}
