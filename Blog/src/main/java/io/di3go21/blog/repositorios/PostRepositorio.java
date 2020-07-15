package io.di3go21.blog.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.di3go21.blog.model.Post;
import io.di3go21.blog.model.Tag;

@Repository
public interface PostRepositorio extends JpaRepository<Post, Long> {
	
	
	
	public List<Post> findByTags(Tag tag);
	
	public List<Post> findByTagsNombre (String nombre);
	

	
//	@Query("select t from Topic t 
//	        join t.user u 
//	        where u.id = :userId 
//	        and u.roles in :roleNames")
//	List<Topic>  findByUserIdAndRoleNameContainedIn(@Param("userId") Integer userId, @Param("roleNames") List<String> roleNames);
	
	
}
