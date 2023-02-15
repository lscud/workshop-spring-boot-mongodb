package com.luisantonio.workshopmongo.Services;

import com.luisantonio.workshopmongo.domain.User;
import com.luisantonio.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Declaração da dependencia com o repository:
    @Autowired //Intanciar um objeto do tipo Repository. Para  que a injeção de dependencias fique transprente ao programador
    private UserRepository repo; //Não preciso instanciar pois o spring ira fazzer isso automatico uando Autowired


    public List<User> findAll(){
        return repo.findAll();
    }

}
