package br.org.fitec.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.org.fitec.workshopmongo.domain.User;

//Camada de acesso a dados(Repository)
@Repository//Definição do reposório de buscas no banco de dados
// MongoRepository<T, ID> => Subinteface específica da inteface Repository para consulta em bancos Mongo
public interface UserRepository extends MongoRepository<User, String>{

}
