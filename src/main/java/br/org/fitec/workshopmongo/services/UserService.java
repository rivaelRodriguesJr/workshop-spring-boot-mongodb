package br.org.fitec.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fitec.workshopmongo.domain.User;
import br.org.fitec.workshopmongo.repository.UserRepository;

@Service//Camada de serviço, que será controlada pelo controlador REST, acessando o banco através do repositorio injetado
public class UserService {
	
	@Autowired//Ao usar esta anotação o Spring procura a definção do objeto e instancia o objeto sozinho, 
			//ou seja, o próprio Spring faz uma classe do tipo DAO.
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

}