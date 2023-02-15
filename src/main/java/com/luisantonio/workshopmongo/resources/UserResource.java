package com.luisantonio.workshopmongo.resources;

import com.luisantonio.workshopmongo.Services.UserService;
import com.luisantonio.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O back end vai expor os controladores RETS para as aplicações. Os controladores REST vao acessar os serviços
// e os serviços irão acessar os objetos da camada de de acesso a dados (REPOSITORY: Objetos responsaveis por efetuar operações basicas de acesso a dados)

@RestController   //para dizer que é uma classe de um resurso WEB implementado por um controlador Rest
@RequestMapping(value = "/users")    //Nome para o resurso
public class UserResource {


    @Autowired //injeção de dependencia (instanciação automática)
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<List<User>> findAll(){  //Poderia retornar apenas a List<User> no entanto o ResponseEntity é um recurso mais sofisticado com recursos HTTP
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //.ok é um metodo que vai instanciar o responserentity ja com a resposta http respondendo que ocorreu com sucesso
    }
}
