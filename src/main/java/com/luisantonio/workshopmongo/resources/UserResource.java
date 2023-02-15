package com.luisantonio.workshopmongo.resources;

import com.luisantonio.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController   //para dizer que é uma classe de um resurso WEB implementado por um controlador Rest
@RequestMapping(value = "/users")    //Nome para o resurso
public class UserResource {

    @RequestMapping(method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<List<User>> findAll(){  //Poderia retornar apenas a List<User> no entanto o ResponseEntity é um recurso mais sofisticado com recursos HTTP
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>(); //List é uma interface e portanto nao poderemos instanciar. PAra isso teremos que colcoar uma implementação da interface que no caso é ArrayList
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list); //.ok é um metodo que vai instanciar o responserentity ja com a resposta http respondendo que ocorreu com sucesso
    }
}
