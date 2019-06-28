package br.org.fitec.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fitec.workshopmongo.domain.User;
import br.org.fitec.workshopmongo.dto.UserDTO;
import br.org.fitec.workshopmongo.repository.UserRepository;
import br.org.fitec.workshopmongo.services.exception.ObjectNotFoundException;

@Service//Camada de serviço, que será controlada pelo controlador REST, acessando o banco através do repositorio injetado
public class UserService {
	
	@Autowired//Ao usar esta anotação o Spring procura a definção do objeto e instancia o objeto sozinho, 
			//ou seja, o próprio Spring faz uma classe do tipo DAO.
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
