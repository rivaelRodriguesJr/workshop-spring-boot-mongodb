package br.org.fitec.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.fitec.workshopmongo.domain.Post;

//Camada de acesso a dados(Repository)
@Repository//Definição do reposório de buscas no banco de dados
// MongoRepository<T, ID> => Subinteface específica da inteface Repository para consulta em bancos Mongo
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String txt);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
