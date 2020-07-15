package io.di3go21.blog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String url;
	private String titulo;
	
	@Lob
	private String contenido;
	
		
	@ManyToMany (fetch = FetchType.EAGER)
	private List<Tag> tags;
	
	@ManyToOne
	private Usuario autor;
	
	@CreationTimestamp
	private Date fecha;
	
	
	

}
