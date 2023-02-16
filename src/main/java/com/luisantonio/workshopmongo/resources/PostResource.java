package com.luisantonio.workshopmongo.resources;

import com.luisantonio.workshopmongo.Services.PostService;
import com.luisantonio.workshopmongo.Services.UserService;
import com.luisantonio.workshopmongo.domain.Post;
import com.luisantonio.workshopmongo.domain.User;
import com.luisantonio.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

//O back end vai expor os controladores RETS para as aplicações. Os controladores REST vao acessar os serviços
// e os serviços irão acessar os objetos da camada de de acesso a dados (REPOSITORY: Objetos responsaveis por efetuar operações basicas de acesso a dados)

@RestController   //para dizer que é uma classe de um resurso WEB implementado por um controlador Rest
@RequestMapping(value = "/posts")    //Nome para o resurso
public class PostResource {


    @Autowired //injeção de dependencia (instanciação automática)
    private PostService service;


    @RequestMapping(value="/{id}", method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<Post> findById(@PathVariable  String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}