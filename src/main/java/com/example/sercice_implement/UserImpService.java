package com.example.sercice_implement;

import com.example.entity.User;
import com.example.repo.UserRepo;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserImpService implements UserService {

    private final UserRepo repo;


    @Override
    public User save(User user) {
        return repo.save(user) ;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
