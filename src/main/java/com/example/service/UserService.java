package com.example.service;

import com.example.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserService {

    User save(User user) ;

    List<User> getAll() ;

    Optional<User> getById(Long id) ;

    void delete(Long id) ;

}
