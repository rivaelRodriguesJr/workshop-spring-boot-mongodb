package br.org.fitec.workshopmongo.resorces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.org.fitec.workshopmongo.domain.User;
import br.org.fitec.workshopmongo.dto.UserDTO;
import br.org.fitec.workshopmongo.services.UserService;

//A classe UserResorce é um controlador REST
@RestController//Define que será um controlador REST
@RequestMapping(value = "/users")//Comando  que precisa ser digitado para controlar a aplicação
public class UserResorce {

	@Autowired//Com a anotação o Spring faz a instanciação
	//Injeção e controle do serviço de consulta na classe
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		UserDTO userDto = new UserDTO(user);  
		return ResponseEntity.ok().body(userDto);
	}

}
