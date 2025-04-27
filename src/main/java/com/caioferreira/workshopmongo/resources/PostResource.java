package com.caioferreira.workshopmongo.resources;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caioferreira.workshopmongo.domain.Post;
import com.caioferreira.workshopmongo.repository.PostRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostRepository service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Post>> findById(@PathVariable String id) throws ObjectNotFoundException {
		Optional<Post> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}	
	
	
}
