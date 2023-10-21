package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Vopros;

@Repository
public interface VorosRepository extends JpaRepository<Vopros, Long> {

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = :email")
//    User findByEmail(String email);

}

