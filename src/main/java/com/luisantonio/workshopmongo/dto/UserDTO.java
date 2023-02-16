package com.luisantonio.workshopmongo.dto;

import com.luisantonio.workshopmongo.domain.User;

import java.io.Serializable;

//neste caso o userDTO terá os mesmos atributos do user porém é um exmeplo para ilustrar a implementação mas a verdade é que enste caso realmente nao rpecisaria do userDTO
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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
}
