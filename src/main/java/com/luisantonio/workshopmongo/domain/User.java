package com.luisantonio.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Aqui no spring para dizer que esse objeto corresponde a uma coleção la no MONGODB (coleção user) preciso acrescentar as anotações @Document e @id (para indicar que se trata de uma coleção no MongoDB)
@Document(collection="user") //se não colocarmos o collection o springdata irá mapear a coleção pelo nome da classe porém com letra minuscula. Então neste caso eu poderia nao colcoar essa collection
public class User implements Serializable {  //Serializable permite que os objetos sejam convertidos em bytes para trafegar em rede


    @Id //sempre colocamos isso em cima do atributo que sera a chave
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true) //aqui no springdata para voce dizer que um atributo está referenciando outra coleção do mongoDB. Esse lazy=true quer dizer que os posts só serão carregados se eu explicitamnte acessa-los. Se eu nao explicitar quando eu carregar os Users só virão os dados dos users
    private List<Post> posts = new ArrayList<>();

    public User(){
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
