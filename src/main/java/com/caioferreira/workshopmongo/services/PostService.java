package com.caioferreira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioferreira.workshopmongo.domain.Post;
import com.caioferreira.workshopmongo.domain.User;
import com.caioferreira.workshopmongo.dto.UserDTO;
import com.caioferreira.workshopmongo.repository.PostRepository;
import com.caioferreira.workshopmongo.repository.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();		
	}
	
	public Post findById(String id) throws ObjectNotFoundException {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
