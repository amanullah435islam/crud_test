package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
 Optional<User> findByEmail(String username);



 //Optional<User> findByEmail(String email);


 boolean existsByEmail(String email);


 boolean existsByPhone(String phone);
}
