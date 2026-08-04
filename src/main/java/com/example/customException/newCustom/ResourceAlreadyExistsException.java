package com.example.customException.newCustom;


public class ResourceAlreadyExistsException
        extends RuntimeException {


    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}