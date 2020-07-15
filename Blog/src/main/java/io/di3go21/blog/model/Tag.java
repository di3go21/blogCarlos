package io.di3go21.blog.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nombre"})})
public class Tag implements Serializable {
	
	
	private static final long serialVersionUID = 7140698530302104994L;


	@Id
	@GeneratedValue
	private long id;
	
	
	private String nombre;

	

}
