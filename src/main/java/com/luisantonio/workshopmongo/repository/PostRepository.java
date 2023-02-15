package com.luisantonio.workshopmongo.repository;

import com.luisantonio.workshopmongo.domain.Post;
import com.luisantonio.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {  //funções como salvar, deletar, alterar ja está imbutido nesse MongoRepository
}
