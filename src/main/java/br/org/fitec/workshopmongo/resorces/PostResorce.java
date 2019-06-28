package br.org.fitec.workshopmongo.resorces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.fitec.workshopmongo.domain.Post;
import br.org.fitec.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResorce {
	
	@Autowired
	PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
