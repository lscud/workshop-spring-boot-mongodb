package com.luisantonio.workshopmongo.Services.exception;

public class ObjectNotFoundException extends RuntimeException { //RunTime nao exige que voce trate a exceção

    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
