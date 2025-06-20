package com.workhub.freelancebackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workhub.freelancebackend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    
    @Query(value = "SELECT * FROM users WHERE email = :email AND BINARY password = :password", nativeQuery = true)
    Optional<User> loginStrict(@Param("email") String email, @Param("password") String password);
    List<User> findByRole(String role);

}
