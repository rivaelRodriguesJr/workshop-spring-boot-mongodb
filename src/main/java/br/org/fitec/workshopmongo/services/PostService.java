package br.org.fitec.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fitec.workshopmongo.domain.Post;
import br.org.fitec.workshopmongo.repository.PostRepository;
import br.org.fitec.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {		
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));									   
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
}
