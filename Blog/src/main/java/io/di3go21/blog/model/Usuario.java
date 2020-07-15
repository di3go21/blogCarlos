package io.di3go21.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor
@Builder
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email","nickname"})})
public class Usuario {
	
	@GeneratedValue
	@Id
	private long id;
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	@CreationTimestamp
	private Date fechaAlta;
	
	private String avatar;
	
	

}
