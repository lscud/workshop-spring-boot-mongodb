package com.luisantonio.workshopmongo.resources;

import com.luisantonio.workshopmongo.Services.UserService;
import com.luisantonio.workshopmongo.domain.Post;
import com.luisantonio.workshopmongo.domain.User;
import com.luisantonio.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//O back end vai expor os controladores RETS para as aplicações. Os controladores REST vao acessar os serviços
// e os serviços irão acessar os objetos da camada de de acesso a dados (REPOSITORY: Objetos responsaveis por efetuar operações basicas de acesso a dados)

@RestController   //para dizer que é uma classe de um resurso WEB implementado por um controlador Rest
@RequestMapping(value = "/users")    //Nome para o resurso
public class UserResource {


    @Autowired //injeção de dependencia (instanciação automática)
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){  //Poderia retornar apenas a List<User> no entanto o ResponseEntity é um recurso mais sofisticado com recursos HTTP
        List<User> list = service.findAll();

        //list.stream irá converter num streming que é uma coleção compativel com as expreções lambda do java 8 em diante
        //map(x -> new UserDTO(x)) o map vai pegar cada elemento X da minha lista original e pra cada elemento x que é um User eu vou retornar um new UserDTO passando x como argumento
        //collect((Collectors.toList()) é para converter novamente o streaming para lista
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect((Collectors.toList()));
        return ResponseEntity.ok().body(listDto); //.ok é um metodo que vai instanciar o responserentity ja com a resposta http respondendo que ocorreu com sucesso
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<UserDTO> findById(@PathVariable  String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST) //Poderia ter usado o @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        //resposta vazia porem nessa resposta vamos colocar um  cabeçalho  com a url do novo recurso criado (BOA PRATICA)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //irá pegar o endereço do novo objeto que eu inseri
        return ResponseEntity.created(uri).build(); //irá me retornar uma resposta vazia com codigo 201 e com o cabeçalho contendo a localização do novo recurso criado
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE) //Poderia ter usado o @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable  String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT) //Poderia ter usado o @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable  String id){
        User obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        //resposta vazia porem nessa resposta vamos colocar um  cabeçalho  com a url do novo recurso criado (BOA PRATICA)
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/posts", method = RequestMethod.GET) //Poderia ter usado o @GetMapping
    public ResponseEntity<List<Post>> findPosts(@PathVariable  String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

}
