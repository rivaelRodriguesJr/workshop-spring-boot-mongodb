package br.org.fitec.workshopmongo.services;

import java.util.Optional;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fitec.workshopmongo.domain.Post;
import br.org.fitec.workshopmongo.repository.PostRepository;
import br.org.fitec.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {		
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
												   
	}
}
