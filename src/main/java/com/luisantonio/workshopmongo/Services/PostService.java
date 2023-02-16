package com.luisantonio.workshopmongo.Services;

import com.luisantonio.workshopmongo.Services.exception.ObjectNotFoundException;
import com.luisantonio.workshopmongo.domain.Post;
import com.luisantonio.workshopmongo.domain.User;
import com.luisantonio.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    //Declaração da dependencia com o repository:
    @Autowired //Intanciar um objeto do tipo Repository. Para  que a injeção de dependencias fique transprente ao programador
    private PostRepository repo; //Não preciso instanciar pois o spring ira fazzer isso automatico uando Autowired


    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
}
