package com.luisantonio.workshopmongo.Services;

import com.luisantonio.workshopmongo.Services.exception.ObjectNotFoundException;
import com.luisantonio.workshopmongo.domain.User;
import com.luisantonio.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Declaração da dependencia com o repository:
    @Autowired //Intanciar um objeto do tipo Repository. Para  que a injeção de dependencias fique transprente ao programador
    private UserRepository repo; //Não preciso instanciar pois o spring ira fazzer isso automatico uando Autowired


    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
