package io.di3go21.blog.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ComentarioRespuesta {
	

	@GeneratedValue
	@Id
	private long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@CreationTimestamp
	private Date date;
	

	@Lob
	private String contenido;
	
	@OneToMany 
	private List<ComentarioRespuesta> replys;
	

}
